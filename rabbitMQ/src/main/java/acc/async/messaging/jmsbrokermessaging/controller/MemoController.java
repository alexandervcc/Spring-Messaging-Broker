package acc.async.messaging.jmsbrokermessaging.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import acc.async.messaging.jmsbrokermessaging.model.Memo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/memo", produces = MediaType.APPLICATION_JSON_VALUE)
public class MemoController {


  @PostMapping(path = "")
  public ResponseEntity<?> receiveMessage(Memo memo) {
    return ResponseEntity.status(HttpStatus.OK).body("Sent");
  }
}
