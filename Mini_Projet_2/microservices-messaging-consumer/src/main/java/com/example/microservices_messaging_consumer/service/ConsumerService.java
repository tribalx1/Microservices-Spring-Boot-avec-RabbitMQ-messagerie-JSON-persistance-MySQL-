package com.example.microservices_messaging_consumer.service;


import com.example.microservices_messaging_consumer.domain.User;

import com.example.microservices_messaging_consumer.repository.UserRepository;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


/**
 * Service Consumer pour écouter les messages RabbitMQ
 * Reçoit les utilisateurs et les persiste dans la base de données
 */
@Service
public class ConsumerService {

    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);


    /**
     * Constructeur avec injection du repository
     * @param userRepository Repository pour la persistance
     */
    @Autowired
    public ConsumerService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    /**
     * Listener RabbitMQ pour recevoir les messages utilisateurs
     * Persiste automatiquement l'utilisateur en base de données
     * 
     * @param user L'utilisateur reçu du message
     */
    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receivedMessage(User user) {
        
        // Sauvegarde de l'utilisateur en base de données
        User saved = userRepository.save(user);
        
        // Logs de confirmation
        logger.info("persisted " + saved);
        logger.info("User recieved: " + user);
        
    }

}
