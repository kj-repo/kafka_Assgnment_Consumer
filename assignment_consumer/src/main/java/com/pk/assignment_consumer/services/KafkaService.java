package com.pk.assignment_consumer.services;

import org.springframework.stereotype.Service;
import com.pk.assignment_consumer.domain.Customer;
import com.pk.assignment_consumer.model.AuditLog;

@Service
public interface KafkaService {

    public AuditLog consumeMessage(Customer customer);

}
