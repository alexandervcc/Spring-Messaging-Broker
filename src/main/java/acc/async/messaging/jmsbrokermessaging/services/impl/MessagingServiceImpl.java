package acc.async.messaging.jmsbrokermessaging.services.impl;

import javax.jms.Destination;

import org.springframework.jms.core.JmsTemplate;
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
    // 1. It is injected the destination, which was defined as a beans
    jmsTemplate.send(orderQueue, session -> session.createObjectMessage(m));

    // 2. It uses a default destination, usually declared in the yml file
    // jmsTemplate.send(session -> session.createObjectMessage(m));

    // 3. You can also use the string name of the destination
    // jmsTemplate.send("localhost:61616", session ->
    // session.createObjectMessage(m));
  }

  @Override
  public void sendConvertedMessage(Memo m) {
    // It will use either a string or a Destination object
    jmsTemplate.convertAndSend("localhost:61616", m);
  }

  @Override
  public void sendConvertedMessageWithPostprocessing(Memo m) {
    // Lambda postProcessor tweaks the message before its sent
    jmsTemplate.convertAndSend("localhost:61616", m, message -> {
      message.setStringProperty("MEMO_TYPE", "INFO");
      return message;
    });
  }

}
