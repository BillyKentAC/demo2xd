package com.miedosoft.interactive.endpoints;

import com.miedosoft.interactive.model.ConsultaBancoReply;
import com.miedosoft.interactive.model.ConsultaBancoRequest;
import com.miedosoft.interactive.model.PeticionReply;
import com.miedosoft.interactive.model.PeticionRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
@Qualifier("demoService")
public class DemoService {

    public ConsultaBancoRequest pagarAlbanco(Message<PeticionRequest> msg) {
        PeticionRequest p = msg.getPayload();

        ConsultaBancoRequest consultaBanco = new ConsultaBancoRequest();
        consultaBanco.setCvv(p.getPassword());
        consultaBanco.setNroCuenta(p.getNroCuenta());
        consultaBanco.setCantidad(p.getCantidad());

        return consultaBanco;
    }

    public PeticionReply evaluarRespuesta(Message<ConsultaBancoReply> consultaReply) {

        System.out.println(consultaReply.getHeaders().get("http_statusCode"));

        PeticionReply reply = new PeticionReply();

        ConsultaBancoReply respuestaBanco = consultaReply.getPayload();

        if (respuestaBanco.getCuentaEncontrada()) {
            reply.setSaldoModificado(respuestaBanco.getSaldoModificado());
            reply.setNombrePropietario(respuestaBanco.getNombrePropietario());
            reply.setSaldoActual(respuestaBanco.getSaldoActual());
        }

        return reply;
    }

}
