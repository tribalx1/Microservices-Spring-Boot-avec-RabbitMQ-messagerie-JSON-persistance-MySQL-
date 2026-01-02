package com.example.spring_rabbitmq_producer;


import org.springframework.amqp.core.*;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;

import org.springframework.amqp.support.converter.MessageConverter;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;


/**
 * Configuration RabbitMQ pour le Producer
 * Définit la queue, l'exchange et le binding entre eux
 */
@Configuration
public class MQConfig {

    // Constantes pour la configuration RabbitMQ
    public static final String QUEUE = "2ite_micro_message_queue";
    public static final String EXCHANGE = "2ite_micro_message_exchange";
    public static final String ROUTING_KEY = "message_routingKey";


    /**
     * Création du bean Queue
     * @return Instance de la queue RabbitMQ
     */
    @Bean
    public Queue queue() {
        return new Queue(QUEUE);
    }


    /**
     * Création du bean TopicExchange
     * @return Instance de l'exchange de type Topic
     */
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }


    /**
     * Définition du binding entre la queue et l'exchange
     * @param queue La queue à lier
     * @param exchange L'exchange à lier
     * @return Le binding configuré
     */
    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(ROUTING_KEY);
    }


    /**
     * Convertisseur de messages pour sérialiser/désérialiser en JSON
     * @return Convertisseur Jackson JSON
     */
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }


    /**
     * Template RabbitMQ pour envoyer des messages
     * @param connectionFactory Factory de connexion RabbitMQ
     * @return Template AMQP configuré
     */
    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }

}
