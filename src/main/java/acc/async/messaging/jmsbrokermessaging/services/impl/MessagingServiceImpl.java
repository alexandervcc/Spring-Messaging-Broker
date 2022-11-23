package acc.async.messaging.jmsbrokermessaging.services.impl;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import acc.async.messaging.jmsbrokermessaging.model.Memo;
import acc.async.messaging.jmsbrokermessaging.services.MessagingService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MessagingServiceImpl implements MessagingService {
  private final JmsTemplate jmsTemplate;
  private final Destination orderQueue;

  @Override
  public void sendMessage(Memo m) {
    jmsTemplate.send(orderQueue, session -> session.createObjectMessage(m));
  }

}