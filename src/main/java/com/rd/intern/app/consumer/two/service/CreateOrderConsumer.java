package com.rd.intern.app.consumer.two.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.rd.intern.app.consts.GlobalConsts.CONSUMER_ORDER_SERVICE;
import com.rd.intern.app.consts.GlobalConsts.CONTAINER_FACTORY_SERVICE;
import com.rd.intern.app.model.Order;

@Service(CONSUMER_ORDER_SERVICE.TWO)
public class CreateOrderConsumer {
    private static final Logger log = LoggerFactory.getLogger(CreateOrderConsumer.class);

    @KafkaListener(topics = "${spring.kafka.order.topic.create-order}", containerFactory=CONTAINER_FACTORY_SERVICE.TWO)
    public void createOrderListener(@Payload Order order, Acknowledgment ack) {
        log.info("Instance2 received order {} ", order);
        ack.acknowledge();
    }
}
