package com.messagequeue.awssqs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sqs")
public class MessageController {
    @Autowired
    private SqsMessageProducer sqsMessageProducer;

    //Test the sending a string message to sqs service
    @GetMapping("/send")
    public String sendMessageToSqs(){
        String message = "Hello World :)";
        sqsMessageProducer.send(message);
        return "Successfully send the message";
    }
}
