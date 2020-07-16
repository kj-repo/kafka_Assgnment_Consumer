package com.pk.assignment_consumer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pk.assignment_consumer.converters.CustomerMaskConverter;
import com.pk.assignment_consumer.domain.Customer;
import com.pk.assignment_consumer.model.AuditLog;

@Service
public class KafkaServiceImpl implements KafkaService {

    @Autowired
    DBLogService dbLogService;

    @Autowired
    CustomerMaskConverter customerMaskConverter;

    @Override
    public AuditLog consumeMessage(Customer customer) {
        Customer maskCustomer = customerMaskConverter.convert(customer);
        AuditLog auditLog = dbLogService.logMessage(maskCustomer);
        return auditLog;
    }

}
