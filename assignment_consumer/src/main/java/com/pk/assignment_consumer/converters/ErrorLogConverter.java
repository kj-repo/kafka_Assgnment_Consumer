package com.pk.assignment_consumer.converters;

import org.springframework.stereotype.Component;
import com.pk.assignment_consumer.domain.ErrorResponse;
import com.pk.assignment_consumer.model.ErrorLog;

@Component
public class ErrorLogConverter {

    public ErrorLog convert(String request, ErrorResponse errorResponse) {
        ErrorLog errorLog = new ErrorLog();
        String payload = request;
        errorLog.setErrorDiscription(errorResponse.getMessage());
        errorLog.setErrorType(errorResponse.getErrorType());
        errorLog.setPayload(payload);
        return errorLog;
    }


}
