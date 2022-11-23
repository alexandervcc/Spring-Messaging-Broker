package acc.async.messaging.jmsbrokermessaging.services.impl;

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

  @Override
  public void sendMessage(Memo m) {
    jmsTemplate.send(session -> session.createObjectMessage(m));
  }

}
