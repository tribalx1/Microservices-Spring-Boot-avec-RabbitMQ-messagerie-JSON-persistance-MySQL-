package com.example.spring_rabbitmq_consumer;


import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Classe principale pour démarrer l'application Spring Boot Consumer
 * Cette application écoute les messages provenant de RabbitMQ
 */
@SpringBootApplication
public class SpringRabbitmqConsumerApplication {

    /**
     * Méthode main pour lancer l'application
     * @param args Arguments de ligne de commande
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringRabbitmqConsumerApplication.class, args);
    }

}
