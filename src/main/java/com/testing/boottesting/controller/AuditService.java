package com.testing.boottesting.controller;

import com.testing.boottesting.entity.AuditEntity;
import com.testing.boottesting.entity.BaseEntity;
import com.testing.boottesting.entity.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuditService {

    private final AuditRepository repository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION)
    public void createAudit(BaseEntity entity) {
        System.out.println("!!!!!!!!!!!!Start create AUDIT + entity.getResult(): " + entity.getResult());
        AuditEntity auditEntity = new AuditEntity();
        auditEntity.setCreatedAt(LocalDateTime.now());
        auditEntity.setStatus(Result.DONE == entity.getResult() ? "OK" : "FAIL");
        repository.save(auditEntity);
    }

    public AuditEntity getEntity(long id) {
        return repository.findById(id).orElse(null);
    }

    public Iterable<AuditEntity> getAll() {
        return repository.findAll();
    }
}
