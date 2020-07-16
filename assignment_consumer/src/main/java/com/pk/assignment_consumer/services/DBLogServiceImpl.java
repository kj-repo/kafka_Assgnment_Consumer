package com.pk.assignment_consumer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pk.assignment_consumer.converters.AuditLogConverter;
import com.pk.assignment_consumer.converters.ErrorLogConverter;
import com.pk.assignment_consumer.domain.Customer;
import com.pk.assignment_consumer.domain.ErrorResponse;
import com.pk.assignment_consumer.model.AuditLog;
import com.pk.assignment_consumer.model.ErrorLog;
import com.pk.assignment_consumer.repository.AuditLogRepository;
import com.pk.assignment_consumer.repository.ErrorLogRepository;


@Service
public class DBLogServiceImpl implements DBLogService {

    @Autowired
    AuditLogRepository auditLogRepository;

    @Autowired
    ErrorLogRepository errorLogRepository;

    @Autowired
    AuditLogConverter auditLogConverter;

    @Autowired
    ErrorLogConverter errorLogConverter;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public AuditLog logMessage(Customer customer) {
        AuditLog auditLog = auditLogConverter.convert(customer);
        return auditLogRepository.save(auditLog);
    }

    @Override
    public ErrorLog logError(Customer request, ErrorResponse errorResponse) {
        String payload = null;
        try {
            payload = objectMapper.writeValueAsString(request);
        } catch (JsonProcessingException e) {

        }
        ErrorLog errorLog = errorLogConverter.convert(payload, errorResponse);
        return errorLogRepository.save(errorLog);
    }
}
