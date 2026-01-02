package com.example.spring_rabbitmq_producer;


import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;


import java.util.Date;

import java.util.UUID;


/**
 * Contrôleur REST pour publier des messages vers RabbitMQ
 * Expose un endpoint POST pour envoyer des messages
 */
@RestController
public class MessagePublisher {

    @Autowired
    private RabbitTemplate template;


    /**
     * Endpoint pour publier un message personnalisé
     * Génère automatiquement un ID unique et une date pour le message
     * 
     * @param message Le message personnalisé à publier
     * @return Confirmation de la publication
     */
    @PostMapping("/publish")
    public String publishMessage(@RequestBody CustomMessage message) {
        
        // Génération d'un identifiant unique pour le message
        message.setMessageId(UUID.randomUUID().toString());
        
        // Ajout de la date actuelle au message
        message.setMessageDate(new Date());


        // Envoi du message vers RabbitMQ
        template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, message);
        
        return "Message Published";
    }

}
