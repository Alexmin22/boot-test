package com.testing.boottesting.controller;

import com.testing.boottesting.entity.AuditEntity;
import com.testing.boottesting.entity.BaseEntity;
import org.springframework.data.repository.CrudRepository;

public interface AuditRepository extends CrudRepository<AuditEntity, Long> {
}
