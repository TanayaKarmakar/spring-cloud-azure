package com.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import java.io.IOException;
//import java.util.concurrent.Executors;
//
//@Configuration
//public class EventHubConfig {
//    @Value("${eventHub.connectionString}")
//    private String connectionString;
//
//    @Bean
//    public EventHubClient setupEventHubConnection() throws IOException, EventHubException {
//        return EventHubClient.createFromConnectionStringSync(connectionString,
//                Executors.newSingleThreadScheduledExecutor());
//    }
//}
