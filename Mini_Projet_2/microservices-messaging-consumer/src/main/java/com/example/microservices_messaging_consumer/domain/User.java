package com.example.microservices_messaging_consumer.domain;


import jakarta.persistence.*;

import lombok.AllArgsConstructor;

import lombok.Data;

import lombok.NoArgsConstructor;

import lombok.ToString;


import java.io.Serializable;


/**
 * Entité JPA représentant un utilisateur
 * Sera persistée dans la base de données MySQL
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "user")
public class User implements Serializable {

    // Clé primaire générée automatiquement
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Identifiant unique de l'utilisateur
    private String userId;

    // Nom de l'utilisateur
    private String userName;

}
