package com.rd.intern.app.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.rd.intern.app.consts.GlobalConsts.CONSUMER_NOTIFICATION_SERVICE;
import com.rd.intern.app.consts.GlobalConsts.CONTAINER_FACTORY_SERVICE;
import com.rd.intern.app.model.Order;

@Service(CONSUMER_NOTIFICATION_SERVICE.ORDER)
public class CreateOrderConsumer {
    private static final Logger log = LoggerFactory.getLogger(CreateOrderConsumer.class);

    @KafkaListener(topics = "${spring.kafka.order.topic.create-order}", containerFactory=CONTAINER_FACTORY_SERVICE.NOTIFICATION)
    public void createOrderListener(@Payload Order order, Acknowledgment ack) {
        log.info("Notification service received order {} ", order);
        ack.acknowledge();
    }
}
