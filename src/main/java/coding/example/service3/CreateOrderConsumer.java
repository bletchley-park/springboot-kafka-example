package coding.example.service3;

import coding.example.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service("Service3")
public class CreateOrderConsumer {

    private static final Logger log = LoggerFactory.getLogger(CreateOrderConsumer.class);

    @KafkaListener(topics = "${spring.kafka.order.topic.create-order}", containerFactory="Service3ContainerFactory")
    public void createOrderListener(@Payload Order order, Acknowledgment ack) throws ExecutionException, InterruptedException {
        log.info("Service3 received order {} ", order);
//        wait(250);
        ack.acknowledge();
    }

}
