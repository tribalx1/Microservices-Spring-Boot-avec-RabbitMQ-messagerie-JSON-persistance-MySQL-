# Spring Boot Messaging with RabbitMQ

This repository contains two demonstration projects illustrating how to implement messaging patterns using **Spring Boot** and **RabbitMQ**.

## 🚀 Project Overview

The repository is divided into two main parts:

### 1. Mini_Projet_1: Spring RabbitMQ Basic
A simple demonstration of producer and consumer services communicating via RabbitMQ.
- **Producer**: Sends messages to a RabbitMQ exchange.
- **Consumer**: Listens to a queue and processes incoming messages.

### 2. Mini_Projet_2: Microservices Messaging
A more advanced implementation showcasing messaging in a microservices architecture.
- **Producer**: A microservice that publishes events or data.
- **Consumer**: A microservice that reacts to events and performs background processing.

## 🛠️ Tech Stack

- **Framework**: Spring Boot 3.5.8
- **Messaging**: RabbitMQ (Spring AMQP)
- **Language**: Java 17
- **Build Tool**: Maven
- **Utilities**: Lombok

## 📋 Prerequisites

Before running the projects, ensure you have the following installed:
- **JDK 17** or higher
- **Maven** 3.8+
- **Docker** (to run RabbitMQ)
- **RabbitMQ** (running on localhost:5672 with default guest/guest credentials)

## 🚦 How to Run

### 1. Start RabbitMQ
The easiest way is using Docker:
```bash
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management
```

### 2. Build and Run Mini_Projet_1
Navigate to each service and run:
```bash
# Start Producer
cd Mini_Projet_1/spring-rabbitmq-producer
mvn spring-boot:run

# Start Consumer
cd Mini_Projet_1/spring-rabbitmq-consumer
mvn spring-boot:run
```

### 3. Build and Run Mini_Projet_2
Navigate to each service and run:
```bash
# Start Producer
cd Mini_Projet_2/microservices-messaging-producer
mvn spring-boot:run

# Start Consumer
cd Mini_Projet_2/microservices-messaging-consumer
mvn spring-boot:run
```

## 📊 RabbitMQ Management UI
Once RabbitMQ is running, you can access the management console at:
- **URL**: [http://localhost:15672](http://localhost:15672)
- **Username**: `guest`
- **Password**: `guest`

---
*Developed as part of the TP 3.1 exercise.*
