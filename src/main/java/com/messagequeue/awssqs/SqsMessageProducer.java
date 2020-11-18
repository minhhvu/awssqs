package com.messagequeue.awssqs;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class SqsMessageProducer {
    private final AmazonSQS amazonSQS;


    @Value("${cloud.aws.sqs.url}")
    private String QueueUrl;

    @Autowired
    public SqsMessageProducer(AmazonSQS amazonSQS){
        this.amazonSQS = amazonSQS;
    }

    //
    public void send(String message){
        SendMessageRequest sendMessageRequest = new SendMessageRequest()
                .withQueueUrl(QueueUrl)
                .withMessageBody(message)
                .withDelaySeconds(1);

        amazonSQS.sendMessage(sendMessageRequest);
    }

}
