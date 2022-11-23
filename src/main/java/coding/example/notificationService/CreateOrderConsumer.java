package coding.example.notificationService;

import coding.example.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service("NotificationService")
public class CreateOrderConsumer {

    private static final Logger log = LoggerFactory.getLogger(CreateOrderConsumer.class);

    @KafkaListener(topics = "${spring.kafka.order.topic.create-order}", containerFactory="NotificationContainerFactory")
    public void cancelReservationListener(@Payload Order order, Acknowledgment ack) throws ExecutionException, InterruptedException {
        log.info("Notification service received order {} ", order);
        ack.acknowledge();
    }

}
