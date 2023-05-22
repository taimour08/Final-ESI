package com.esi.studentservice.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {

    @Bean
    public NewTopic RPLTopicCreation(){
    return TopicBuilder.name("RPLCreatedTopic")
    .build();
    }

    @Bean
    public NewTopic SendRPLRequestTopicCreation(){
    return TopicBuilder.name("RPLRequestTopic")
    .build();
    }
}