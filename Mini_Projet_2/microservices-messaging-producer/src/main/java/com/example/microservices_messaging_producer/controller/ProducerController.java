package com.example.microservices_messaging_producer.controller;


import com.example.microservices_messaging_producer.domain.User;

import com.example.microservices_messaging_producer.service.ProducerService;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


/**
 * Contrôleur REST pour gérer les requêtes de production de messages
 * Expose l'API pour envoyer des utilisateurs via RabbitMQ
 */
@RestController
@RequestMapping("/api/")
public class ProducerController {

    private final ProducerService producerService;
    private static final Logger logger = LoggerFactory.getLogger(ProducerController.class);


    /**
     * Constructeur avec injection du service producer
     * @param producerService Service de production de messages
     */
    @Autowired
    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }


    /**
     * Endpoint POST pour produire un message utilisateur
     * @param user L'utilisateur à envoyer
     * @return Réponse HTTP avec confirmation
     */
    @PostMapping("/produce")
    public ResponseEntity<String> sendMessage(@RequestBody User user) {
        
        // Envoi du message via le service
        producerService.sendMessage(user);
        
        // Log de l'envoi
        logger.info("user sent: " + user);
        
        return ResponseEntity.ok("user sent: " + user);
    }

}
