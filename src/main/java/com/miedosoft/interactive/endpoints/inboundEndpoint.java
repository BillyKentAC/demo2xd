package com.miedosoft.interactive.endpoints;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.miedosoft.interactive.model.ConsultaBancoRequest;
import com.miedosoft.interactive.model.PeticionReply;
import com.miedosoft.interactive.model.PeticionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Qualifier("inboundEndpoint")
public class inboundEndpoint {

    @Autowired
    @Qualifier("get_send_channel")
    MessageChannel getSendChannel;

    @Autowired
    @Qualifier("get_receive_channel")
    PollableChannel getRecieveChannel;


    @Qualifier("post")
    public Message<?> post(Message<PeticionRequest> msg) {

        PeticionRequest p = msg.getPayload();

        // Hacemos la petición de pago al banco
        String rpta = consultarBanco(p);

        // Analizamos la respuesta y creamos un objeto Reply
        PeticionReply reply = analizarRespuesta(rpta);

        return MessageBuilder.withPayload(reply).copyHeadersIfAbsent(msg.getHeaders())
                .setHeader("http_statusCode", HttpStatus.OK).build();
    }



    private PeticionReply analizarRespuesta(String rpta) {
        // Convertimos la respuesta en forma de string a json
        JsonObject respuesta = new JsonParser().parse(rpta).getAsJsonObject();

        // Creamos un objeto respuesta y lo enviamos con el codigo ok
        PeticionReply reply = new PeticionReply();

        if (respuesta.get("saldoActual").isJsonNull()) {
            reply.setSaldoActual(null);
        } else {
            reply.setSaldoActual(respuesta.get("saldoActual").getAsDouble());
        }
        if (respuesta.get("nombrePropietario").isJsonNull()) {
            reply.setNombrePropietario(null);
        } else {
            reply.setNombrePropietario(respuesta.get("nombrePropietario").getAsString());
        }
        if (respuesta.get("saldoModificado").isJsonNull()) {
            reply.setSaldoModificado(null);
        } else {
            reply.setSaldoModificado(respuesta.get("saldoModificado").getAsDouble());
        }
        return reply;


    }

    private String consultarBanco(PeticionRequest p) {

        // Enviamos la peticion al servicio externo
        ConsultaBancoRequest request = new ConsultaBancoRequest();
        request.setCvv(p.getPassword());
        request.setNroCuenta(p.getNroCuenta());
        request.setCantidad(p.getCantidad());

        Message message = MessageBuilder.withPayload(request).build();
        getSendChannel.send(message);

        // Obtenemos la respuesta
        String rpta = getRecieveChannel.receive().getPayload().toString();

        return rpta;

    }


}
