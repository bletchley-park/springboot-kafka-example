package com.rd.intern.app.service.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class CreateOrderProducerConfig {
    @Value("${spring.kafka.order.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public <K, V> ProducerFactory<K, V> createOrderProducerFactory(){
        Map<String,Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public <K, V> KafkaTemplate<K, V> createOrderKafkaTemplate(ProducerFactory<K, V> createOrderProducerFactory){
        return new KafkaTemplate<>(createOrderProducerFactory);
    }
    
//    @Bean
//    public <K, V> KafkaTemplate<K, V> createOrderKafkaTemplate(){
//        return new KafkaTemplate<>(createOrderProducerFactory());
//    }
}
