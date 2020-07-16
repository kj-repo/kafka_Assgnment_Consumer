package com.pk.assignment_consumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.pk.assignment_consumer.domain.Customer;
import com.pk.assignment_consumer.services.KafkaService;

@Service
public class KafkaConsumerService {
    private static final Logger log = LoggerFactory.getLogger(KafkaConsumerService.class);

    @Autowired
    KafkaService kafkaService;

    @KafkaListener(topics = {"pk"})
    public void getTopics(Customer customer) {
        log.info("Kafka Consumer Request data- " + customer.toString());
        kafkaService.consumeMessage(customer);
    }
}
