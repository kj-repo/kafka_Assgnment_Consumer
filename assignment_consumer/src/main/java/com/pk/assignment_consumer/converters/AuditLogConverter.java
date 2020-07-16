package com.pk.assignment_consumer.converters;

import org.springframework.stereotype.Component;
import com.pk.assignment_consumer.domain.Customer;
import com.pk.assignment_consumer.model.AuditLog;

@Component
public class AuditLogConverter {

    public AuditLog convert(Customer customer) {
        AuditLog auditLog = new AuditLog();
        String customerNumber = (String) customer.getCustomerNumber();
        String payload = customer.toString();
        auditLog.setCustomerNumber(customerNumber);
        auditLog.setPayload(payload);
        return auditLog;
    }


}
