package com.benneighbour.CloneBnb.bookingservice.receiver;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ben Neighbour
 * @created 30/08/2020
 * @project CloneBnb
 */
@Configuration
public class Config {

  @Autowired private ConnectionFactory factory;

  public static final String q1 = "Q1";
  public static final String e1 = "E1";
  public static final String r1 = "R1";

  @Bean
  public Queue queue() {
    return QueueBuilder.durable(q1).build();
  }

  @Bean
  public DirectExchange exchange() {
    return new DirectExchange(e1);
  }

  @Bean
  public Binding binding(DirectExchange exchange) {
    return BindingBuilder.bind(queue()).to(exchange).with(r1);
  }

  @Bean
  public RabbitTemplate rabbitTemplate() {
    RabbitTemplate tpl = new RabbitTemplate(factory);
    tpl.setMessageConverter(jsonConverter());
    tpl.setReplyTimeout(5000L);
    return tpl;
  }

  @Bean
  public Queue queueA() {
    return new AnonymousQueue();
  }

  @Bean
  public Binding bindingA(DirectExchange direct, Queue queueA) {
    return BindingBuilder.bind(queueA).to(direct).with("booking-route");
  }

  @Bean
  public Jackson2JsonMessageConverter jsonConverter() {
    return new Jackson2JsonMessageConverter();
  }
}
