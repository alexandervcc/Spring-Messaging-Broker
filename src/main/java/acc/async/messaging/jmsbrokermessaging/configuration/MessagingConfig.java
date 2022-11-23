package acc.async.messaging.jmsbrokermessaging.configuration;

import javax.jms.Destination;

import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {
  @Bean
  public Destination memoQueue() {
    return new ActiveMQQueue("memo.queue");
  }
}
