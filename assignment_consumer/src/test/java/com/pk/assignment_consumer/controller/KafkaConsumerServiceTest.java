package com.pk.assignment_consumer.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pk.assignment_consumer.controller.KafkaConsumerService;
import com.pk.assignment_consumer.domain.Address;
import com.pk.assignment_consumer.domain.Customer;
import com.pk.assignment_consumer.domain.Customer.CustomerStatusEnum;
import com.pk.assignment_consumer.model.AuditLog;
import com.pk.assignment_consumer.services.KafkaService;

@RunWith(MockitoJUnitRunner.class)
public class KafkaConsumerServiceTest {

    @MockBean
    private KafkaService kafkaService;

    @Autowired
    private ObjectMapper objectMapper;

    @InjectMocks
    @Autowired
    private KafkaConsumerService kafkaConsumerService;


    @Test
    public void testgetTopicsWhenPassingValidCustomerShouldAddAuditLogObjectinDB()
            throws Exception {
        Mockito.when(kafkaService.consumeMessage(Mockito.any(Customer.class)))
                .thenReturn(getMockAuditLog());
        kafkaConsumerService.getTopics(createCustomer());

    }

    private AuditLog createAuditLog() throws JsonProcessingException {
        Customer customer = createCustomer();
        AuditLog auditLog = new AuditLog();
        auditLog.setCustomerNumber((String) customer.getCustomerNumber());
        auditLog.setPayload(objectMapper.writeValueAsString(customer));
        return auditLog;
    }

    private AuditLog getMockAuditLog() throws JsonProcessingException {
        AuditLog auditLog = createAuditLog();
        auditLog.setId(10L);
        return auditLog;
    }

    private Customer createCustomer() {
        Customer customer = new Customer();
        customer.setAddress(createAddress());
        customer.setBirthdate("01-01-2018");
        customer.setCountry("India");
        customer.setCountryCode("IN");
        customer.setCustomerNumber("C000001");
        customer.setEmail("email@gmail.com");
        customer.setCustomerStatus(CustomerStatusEnum.RESTORED);
        customer.setFirstName("firstnamefoo");
        customer.setLastName("lastnamefoo");
        customer.setMobileNumber("1234567890");
        return customer;

    }

    private Address createAddress() {
        Address address = new Address();
        address.setAddressLine1("AddressLine1");
        address.setAddressLine2("AddressLine2");
        address.setPostalCode("52001");
        address.setStreet("Street");
        return address;
    }

}
