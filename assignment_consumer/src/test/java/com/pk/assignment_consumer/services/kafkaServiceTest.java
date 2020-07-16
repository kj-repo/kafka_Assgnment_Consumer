package com.pk.assignment_consumer.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pk.assignment_consumer.domain.Address;
import com.pk.assignment_consumer.domain.Customer;
import com.pk.assignment_consumer.domain.Customer.CustomerStatusEnum;
import com.pk.assignment_consumer.model.AuditLog;
import com.pk.assignment_consumer.services.DBLogService;
import com.pk.assignment_consumer.services.KafkaService;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class kafkaServiceTest {
    @MockBean
    private DBLogService dbLogService;

    @Autowired
    private ObjectMapper objectMapper;

    @InjectMocks
    @Autowired
    private KafkaService kafkaService;


    @Test
    public void testconsumeMessageWhenPassingValidCustomerShouldAddAuditLogObjectinDB()
            throws Exception {
        Mockito.when(dbLogService.logMessage(Mockito.any(Customer.class)))
                .thenReturn(getMockAuditLog());

        AuditLog result = kafkaService.consumeMessage(createCustomer());

        assertNotNull(result);
        assertEquals(10L, result.getId());
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
        customer.setBirthdate("2-12-2012");
        customer.setCountry("India");
        customer.setCountryCode("IN");
        customer.setCustomerNumber("C000001");
        customer.setEmail("email@gmail.com");
        customer.setCustomerStatus(CustomerStatusEnum.RESTORED);
        customer.setFirstName("Foo");
        customer.setLastName("boo");
        customer.setMobileNumber("1234567890");
        return customer;

    }

    private Address createAddress() {
        Address address = new Address();
        address.setAddressLine1("AddressLine1");
        address.setAddressLine2("AddressLine2");
        address.setPostalCode("12345");
        address.setStreet("Street");
        return address;
    }
}
