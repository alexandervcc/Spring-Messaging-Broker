package acc.async.messaging.jmsbrokermessaging.services;

import acc.async.messaging.jmsbrokermessaging.model.Memo;

public interface MessagingService {
  public void sendMessage(Memo m);
}
