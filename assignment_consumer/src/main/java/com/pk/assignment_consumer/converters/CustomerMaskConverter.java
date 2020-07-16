package com.pk.assignment_consumer.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.pk.assignment_consumer.constants.ConsumerConstant;
import com.pk.assignment_consumer.domain.Customer;

@Component
public class CustomerMaskConverter implements Converter<Customer, Customer> {

    @Override
    public Customer convert(Customer source) {
        Customer customer = new Customer();
        customer.setCustomerNumber(((String) source.getCustomerNumber())
                .replaceAll(ConsumerConstant.NUMBER_MASK, "*"));
        customer.setFirstName(source.getFirstName());
        customer.setLastName(source.getLastName());
        customer.setCustomerStatus(source.getCustomerStatus());
        customer.setAddress(source.getAddress());
        customer.setBirthdate(source.getBirthdate().replaceAll(ConsumerConstant.DATE_MASK, "*"));
        customer.setCountry(source.getCountry());
        customer.setCountryCode(source.getCountryCode());
        customer.setEmail(source.getEmail().replaceAll(ConsumerConstant.EMAIL_MASK, "*"));
        customer.setMobileNumber(source.getMobileNumber());

        return customer;
    }

}
