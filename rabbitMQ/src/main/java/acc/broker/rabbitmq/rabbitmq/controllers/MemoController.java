package acc.broker.rabbitmq.rabbitmq.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import acc.broker.rabbitmq.rabbitmq.model.Memo;
import acc.broker.rabbitmq.rabbitmq.services.interfaces.MemoService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/memo")
@AllArgsConstructor
public class MemoController {
    private final MemoService memoService;

    @PostMapping(value = "/")
    public ResponseEntity<?> postMemo(Memo memo) {
        this.memoService.sendMemo(memo);
        return ResponseEntity.status(HttpStatus.OK).body("Sent");
    }

    @PostMapping(value = "/convert")
    public ResponseEntity<?> postConvertMemo(Memo memo) {
        this.memoService.convertAndSendMemo(memo);
        return ResponseEntity.status(HttpStatus.OK).body("Sent Converted");
    }
}
