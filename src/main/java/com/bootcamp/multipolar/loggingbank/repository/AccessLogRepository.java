package com.bootcamp.multipolar.loggingbank.repository;

import com.bootcamp.multipolar.loggingbank.domain.AccessLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccessLogRepository extends MongoRepository<AccessLog, String> {
}
