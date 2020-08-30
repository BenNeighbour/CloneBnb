package com.benneighbour.CloneBnb.sagaservice.config;

import com.benneighbour.CloneBnb.commonlibrary.SagaProvider;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ben Neighbour
 * @created 30/08/2020
 * @project CloneBnb
 */
@Configuration
public class Config {

    // Beans needed for events here

    @Bean
    public DirectExchange direct() {
        return new DirectExchange("sub-services-router");
    }

    @Bean
    public SagaProvider sender() {
        return new SagaProvider();
    }

    @Bean
    public Jackson2JsonMessageConverter jsonConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue replyQueue() {
        return QueueBuilder.durable("services-replies-queue").build();
    }

    @Bean
    public AsyncRabbitTemplate template(ConnectionFactory connectionFactory, RabbitTemplate template) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setQueueNames(replyQueue().getName());
        return new AsyncRabbitTemplate(template, container);
    }

}
