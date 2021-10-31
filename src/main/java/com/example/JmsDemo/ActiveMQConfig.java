package com.example.JmsDemo;

import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@Configuration
public class ActiveMQConfig {

    public static final String REQUEST_QUEUE = "request-queue";
    public static final String REQUEST_REPLY_2_QUEUE = "request-reply-2-queue";

}