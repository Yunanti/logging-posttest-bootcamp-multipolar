package com.bootcamp.multipolar.loggingbank.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "access_logs_bank")
@ToString
@EqualsAndHashCode
public class AccessLog {
    @Id
    private String id;
    private String httpMethod;
    private String requestUri;
    private int responseStatusCode;
    private String content;
    private String clientIP;
    private String userAgent;
    private LocalDateTime timeStamp = LocalDateTime.now();
}

