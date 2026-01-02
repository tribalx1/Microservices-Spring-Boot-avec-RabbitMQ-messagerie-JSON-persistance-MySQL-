package com.example.microservices_messaging_producer;


import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Classe principale de l'application Messaging Producer
 * Point d'entrée de l'application microservice producteur
 */
@SpringBootApplication
public class MessagingApplication {

    /**
     * Méthode main pour démarrer l'application
     * @param args Arguments de ligne de commande
     */
    public static void main(String[] args) {
        SpringApplication.run(MessagingApplication.class, args);
    }

}
