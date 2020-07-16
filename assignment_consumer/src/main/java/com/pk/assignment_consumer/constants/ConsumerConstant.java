package com.pk.assignment_consumer.constants;

public class ConsumerConstant {
    public static final String NUMBER_MASK = ".(?=.{4,}$)";
    public static final String EMAIL_MASK = "(?<=.{3}).(?=.*@)";
    public static final String DATE_MASK = "(?!=^)[0-9](?=.{4,}$)";
    public static final String ERROR_STATUS = "ERROR";
    public static final String SUCCESS_STATUS = "SUCCESS";
    public static final String KAFKA_TOPIC_NAME = "pka";



    private ConsumerConstant() {
        throw new IllegalStateException("Utility class");
    }
}
