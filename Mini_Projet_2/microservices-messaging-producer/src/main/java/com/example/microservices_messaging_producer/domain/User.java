package com.example.microservices_messaging_producer.domain;


import lombok.AllArgsConstructor;

import lombok.Data;

import lombok.NoArgsConstructor;

import lombok.ToString;

import org.springframework.stereotype.Component;


import java.io.Serializable;


/**
 * Classe de domaine représentant un utilisateur
 * Implémente Serializable pour permettre la sérialisation
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class User implements Serializable {

    // Identifiant unique de l'utilisateur
    private String userId;

    // Nom de l'utilisateur
    private String userName;

}
