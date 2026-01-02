package com.example.spring_rabbitmq_producer;


import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Classe principale pour démarrer l'application Spring Boot Producer
 * Cette application sert de point d'entrée pour publier des messages vers RabbitMQ
 */
@SpringBootApplication
public class SpringRabbitmqProducerApplication {

    /**
     * Méthode main pour lancer l'application
     * @param args Arguments de ligne de commande
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringRabbitmqProducerApplication.class, args);
    }

}
