package com.example.spring_rabbitmq_consumer;


import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.stereotype.Component;


/**
 * Listener pour recevoir et traiter les messages de RabbitMQ
 * Écoute en permanence la queue configurée
 */
@Component
public class MessageListener {


    /**
     * Méthode qui écoute la queue RabbitMQ
     * Affiche le message reçu dans la console
     * 
     * @param message Le message personnalisé reçu
     */
    @RabbitListener(queues = MQConfig.QUEUE)
    public void listener(CustomMessage message) {
        
        // Affichage du message reçu dans la console
        System.out.println(message);
        
    }

}
