package com.app.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class KafkaSink {
    private Logger logger = LoggerFactory.getLogger(KafkaSink.class);

    @StreamListener(Sink.INPUT)
    public void handleMessage(String message) {
        logger.info("New message received: " + message);
    }
}
