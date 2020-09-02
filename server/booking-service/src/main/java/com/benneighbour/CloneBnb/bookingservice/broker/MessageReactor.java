package com.benneighbour.CloneBnb.bookingservice.broker;

import com.benneighbour.CloneBnb.commonlibrary.MessageConverter;
import com.benneighbour.CloneBnb.commonlibrary.MessageDTO;
import com.benneighbour.CloneBnb.commonlibrary.Status;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author Ben Neighbour
 * @created 02/09/2020
 * @project CloneBnb
 */
@Component
public class MessageReactor {

  private final RabbitTemplate template;

  public MessageReactor(final RabbitTemplate template) {
    this.template = template;
  }

  @RabbitListener(queues = "booking.queue")
  public void react(Message message) throws Exception {
    MessageDTO response = MessageConverter.decode(message.getBody().toString(), MessageDTO.class);

    if (response.getStatus().equals(Status.ROLLBACK)) {
      // Perform rollback
      throw new Exception("ROLLBACK HERE!");
    } else if (response.getStatus().equals(Status.FAILED) || response.getStatus().equals(Status.PENDING)) {
      throw new Exception("ERROR HERE!");
    }

    // Run the command here

  }

  public void sendMessage(MessageDTO sendingMessage) throws JsonProcessingException, Exception {
    try {
      template.setRoutingKey(sendingMessage.getDestination());
      sendingMessage.setStatus(Status.PENDING);

      MessageProperties props =
              MessagePropertiesBuilder.newInstance()
                      .setMessageId(UUID.randomUUID().toString())
                      .build();

      Message message =
              new Message(MessageConverter.encode(sendingMessage).getBytes(), props);

      template.send(message);
    } catch (Exception e) {
      throw new Exception();
    }
  }
}
