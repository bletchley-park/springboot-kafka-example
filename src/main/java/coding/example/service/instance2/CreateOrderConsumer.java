package coding.example.service.instance2;

import coding.example.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service("orderConsumerInstance2Service")
public class CreateOrderConsumer {

    private static final Logger log = LoggerFactory.getLogger(CreateOrderConsumer.class);

    @KafkaListener(topics = "${spring.kafka.order.topic.create-order}", containerFactory="containerFactoryInstance2Service")
    public void createOrderListener(@Payload Order order, Acknowledgment ack) {
        log.info("Instance2 received order {} ", order);
        ack.acknowledge();
    }

}
