package com.example.microservices_messaging_consumer.repository;


import com.example.microservices_messaging_consumer.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


/**
 * Repository pour gérer la persistance des utilisateurs
 * Utilise Spring Data JPA pour les opérations CRUD
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
