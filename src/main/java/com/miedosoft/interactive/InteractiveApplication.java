package com.miedosoft.interactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
@ImportResource({"http-outbound-gateway.xml", "http-inbound-adapter.xml"})
public class InteractiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(InteractiveApplication.class, args);
    }


}
