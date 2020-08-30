package com.benneighbour.CloneBnb.listingservice.receiver;

import org.springframework.amqp.core.*;
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

    @Bean
    public DirectExchange direct() {
        return new DirectExchange("sub-services-router");
    }

    @Bean
    public Queue queueA() {
        return new AnonymousQueue();
    }

    @Bean
    public Binding bindingA(DirectExchange direct, Queue queueA) {
        return BindingBuilder.bind(queueA).to(direct).with("listing-route");
    }

    @Bean
    public ReceiverService receiver() {
        return new ReceiverService();
    }

    @Bean
    public Jackson2JsonMessageConverter jsonConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
