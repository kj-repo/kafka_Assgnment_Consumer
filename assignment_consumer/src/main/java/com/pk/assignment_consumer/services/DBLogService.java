package com.pk.assignment_consumer.services;

import org.springframework.stereotype.Service;
import com.pk.assignment_consumer.domain.Customer;
import com.pk.assignment_consumer.domain.ErrorResponse;
import com.pk.assignment_consumer.model.AuditLog;
import com.pk.assignment_consumer.model.ErrorLog;

@Service
public interface DBLogService {

    public AuditLog logMessage(Customer customer);

    public ErrorLog logError(Customer request, ErrorResponse errorResponse);
}
