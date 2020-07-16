package com.pk.assignment_consumer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pk.assignment_consumer.model.AuditLog;

@Repository
public interface AuditLogRepository extends CrudRepository<AuditLog, Long> {

}
