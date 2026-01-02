package com.example.microservices_messaging_producer.config;


import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;

import org.springframework.amqp.support.converter.MessageConverter;

import org.springframework.context.annotation.Bean;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Configuration;


/**
 * Configuration RabbitMQ pour l'application Producer
 * Définit les connexions et les convertisseurs de messages
 */
@Configuration
public class RabbitMQConfig {

    @Value("${spring.rabbitmq.host}")
    String host;

    @Value("${spring.rabbitmq.username}")
    String username;

    @Value("${spring.rabbitmq.password}")
    String password;

    @Value("${spring.rabbitmq.port}")
    int port;


    /**
     * Configuration de la factory de connexion RabbitMQ
     * @return Factory de connexion cachée configurée
     */
    @Bean
    CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory cf = new CachingConnectionFactory(host, port);
        cf.setUsername(username);
        cf.setPassword(password);
        return cf;
    }


    /**
     * Convertisseur de messages au format JSON
     * @return Convertisseur Jackson pour JSON
     */
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }


    /**
     * Configuration du template RabbitMQ
     * @param connectionFactory Factory de connexion
     * @return Template RabbitMQ configuré avec convertisseur JSON
     */
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

}
