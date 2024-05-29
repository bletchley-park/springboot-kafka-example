package com.rd.intern.app.resource;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rd.intern.app.model.Order;
import com.rd.intern.app.service.kafka.CreateOrderProducer;

@RequestMapping("/orders")
@RestController
public class OrderResource {
	
    private final CreateOrderProducer createOrderProducer;

    public OrderResource(CreateOrderProducer createOrderProducer) {
        this.createOrderProducer = createOrderProducer;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) throws ExecutionException, InterruptedException {
        createOrderProducer.sendCreateOrderEvent(order);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    
    @GetMapping
    public ResponseEntity<List<Order>> getOrders() throws ExecutionException, InterruptedException {
        return new ResponseEntity<>(HttpStatus.OK).ok(Arrays.asList(new Order("ord1", new Date(), "first") ,new Order("ord2", new Date(), "second")));
    }
    
}
