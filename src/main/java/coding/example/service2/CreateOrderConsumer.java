package coding.example.service2;

import coding.example.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service("Service2")
public class CreateOrderConsumer {

    private static final Logger log = LoggerFactory.getLogger(CreateOrderConsumer.class);

    @KafkaListener(topics = "${spring.kafka.order.topic.create-order}", containerFactory="Service2ContainerFactory")
    public void createOrderListener(@Payload Order order, Acknowledgment ack) throws ExecutionException, InterruptedException {
        log.info("Service2 received order {} ", order);
//        wait(500);
        ack.acknowledge();
    }

}
