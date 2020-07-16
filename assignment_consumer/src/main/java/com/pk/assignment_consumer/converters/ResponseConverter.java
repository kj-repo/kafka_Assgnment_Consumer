package com.pk.assignment_consumer.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.pk.assignment_consumer.domain.SuccessResponse;

@Component
public class ResponseConverter implements Converter<String, SuccessResponse> {
    @Override
    public SuccessResponse convert(String message) {
        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setMessage(message);
        successResponse.setStatus("SUCCESS");
        return successResponse;

    }
}
