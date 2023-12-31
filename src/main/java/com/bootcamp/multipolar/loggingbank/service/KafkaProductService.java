package com.bootcamp.multipolar.loggingbank.service;

import com.bootcamp.multipolar.loggingbank.domain.AccessLog;
import com.bootcamp.multipolar.loggingbank.repository.AccessLogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaProductService {

    private final ObjectMapper objectMapper; //untuk mapping dari stringnya kafka ke objectnya java, jadi objectnya java bisa disimpan di mongodb
    private final AccessLogRepository accessLogRepository;

    @Autowired
    public KafkaProductService(ObjectMapper objectMapper, AccessLogRepository accessLogRepository) {
        this.objectMapper = objectMapper;
        this.accessLogRepository = accessLogRepository;
    }

    @KafkaListener(topics = "access_logs_bank")
    public void receiveMessage(String message) {
        try {
            // Deserialize the JSON message into an AccessLog object
            AccessLog accessLog = objectMapper.readValue(message, AccessLog.class);
            System.out.println("Received message: " + accessLog);
            accessLogRepository.insert(accessLog);
        } catch (Exception e) {
            // Handle any exceptions that may occur during deserialization
            System.err.println("Error processing message: " + e.getMessage());
        }
    }
}

