package coding.example.service.instance1;

import coding.example.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service("orderConsumerInstance1Service")
public class CreateOrderConsumer {

    private static final Logger log = LoggerFactory.getLogger(CreateOrderConsumer.class);

    @KafkaListener(topics = "${spring.kafka.order.topic.create-order}", containerFactory="containerFactoryInstance1Service")
    public void createOrderListener(@Payload Order order, Acknowledgment ack) {
        log.info("Instance1 received order {} ", order);
        ack.acknowledge();
    }

}
