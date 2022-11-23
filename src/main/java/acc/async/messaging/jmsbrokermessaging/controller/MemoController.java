package acc.async.messaging.jmsbrokermessaging.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import acc.async.messaging.jmsbrokermessaging.model.Memo;
import acc.async.messaging.jmsbrokermessaging.services.MessagingService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/memo", produces = MediaType.APPLICATION_JSON_VALUE)
public class MemoController {

  private final MessagingService messagingService;

  @PostMapping(path = "/")
  public ResponseEntity<?> receiveMessage(Memo memo) {
    //Producer: send message into the broker in order to be consumed
    this.messagingService.sendMessage(memo);
    return ResponseEntity.status(HttpStatus.OK).build();
  }
}
