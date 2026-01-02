package com.example.spring_rabbitmq_consumer;


import lombok.AllArgsConstructor;

import lombok.Data;

import lombok.NoArgsConstructor;

import lombok.ToString;


import java.util.Date;


/**
 * Classe représentant un message personnalisé
 * Utilise Lombok pour générer automatiquement les getters, setters, constructeurs et toString
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomMessage {

    // Identifiant unique du message
    private String messageId;

    // Contenu du message
    private String message;

    // Date de création du message
    private Date messageDate;

}
