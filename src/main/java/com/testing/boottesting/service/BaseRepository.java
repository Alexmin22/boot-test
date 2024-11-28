package com.testing.boottesting.service;

import com.testing.boottesting.entity.BaseEntity;
import org.springframework.data.repository.CrudRepository;

public interface BaseRepository extends CrudRepository<BaseEntity, Long> {
}
