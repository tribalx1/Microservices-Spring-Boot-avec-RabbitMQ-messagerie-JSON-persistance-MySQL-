package com.example.microservices_messaging_producer.service;


import com.example.microservices_messaging_producer.domain.User;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;


/**
 * Service pour publier des utilisateurs vers RabbitMQ
 * Gère l'envoi des messages utilisateurs
 */
@Service
public class ProducerService {

    private final RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routingkey}")
    private String routingkey;


    /**
     * Constructeur avec injection du RabbitTemplate
     * @param rabbitTemplate Template pour communiquer avec RabbitMQ
     */
    @Autowired
    public ProducerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    /**
     * Méthode pour envoyer un utilisateur vers RabbitMQ
     * @param user L'utilisateur à envoyer
     */
    public void sendMessage(User user) {
        rabbitTemplate.convertAndSend(exchange, routingkey, user);
    }

}
