package coding.example.orderService.controller;

import coding.example.orderService.kafka.CreateOrderProducer;
import coding.example.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RequestMapping("/orders")
@RestController
public class OrderController {

    private final CreateOrderProducer createOrderProducer;

    public OrderController(CreateOrderProducer createOrderProducer) {
        this.createOrderProducer = createOrderProducer;
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody Order order) throws ExecutionException, InterruptedException {
        createOrderProducer.sendCreateOrderEvent(order);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
