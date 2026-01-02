package com.example.microservices_messaging_consumer;


import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Classe principale de l'application Messaging Consumer
 * Point d'entrée de l'application microservice consommateur
 */
@SpringBootApplication
public class MicroservicesMessagingConsumerApplication {

    /**
     * Méthode main pour démarrer l'application
     * @param args Arguments de ligne de commande
     */
    public static void main(String[] args) {
        SpringApplication.run(MicroservicesMessagingConsumerApplication.class, args);
    }

}
