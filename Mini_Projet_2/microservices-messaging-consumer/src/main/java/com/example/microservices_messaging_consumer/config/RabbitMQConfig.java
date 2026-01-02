package com.example.microservices_messaging_consumer.config;


import org.springframework.amqp.core.*;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;

import org.springframework.amqp.support.converter.MessageConverter;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;


/**
 * Configuration RabbitMQ pour l'application Consumer
 * Définit la queue, l'exchange, le binding et les connexions
 */
@Configuration
public class RabbitMQConfig {

    @Value("${spring.rabbitmq.queue}")
    private String queue;

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routingkey}")
    private String routingKey;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private int port;


    /**
     * Création de la queue RabbitMQ
     * @return Queue durable configurée
     */
    @Bean
    Queue queue() {
        return new Queue(queue, true);
    }


    /**
     * Création de l'exchange direct
     * @return Exchange direct durable
     */
    @Bean
    Exchange myExchange() {
        return ExchangeBuilder.directExchange(exchange).durable(true).build();
    }


    /**
     * Création du binding entre queue et exchange
     * @return Binding configuré avec la routing key
     */
    @Bean
    Binding binding() {
        return BindingBuilder
                .bind(queue())
                .to(myExchange())
                .with(routingKey)
                .noargs();
    }


    /**
     * Configuration de la factory de connexion
     * @return Factory de connexion cachée
     */
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory cf = new CachingConnectionFactory(host, port);
        cf.setUsername(username);
        cf.setPassword(password);
        return cf;
    }


    /**
     * Convertisseur de messages JSON
     * @return Convertisseur Jackson
     */
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }


    /**
     * Configuration du template RabbitMQ
     * @param connectionFactory Factory de connexion
     * @return Template configuré
     */
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

}
