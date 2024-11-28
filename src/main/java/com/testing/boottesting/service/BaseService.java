package com.testing.boottesting.service;

import com.testing.boottesting.entity.BaseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class BaseService {
    private final BaseRepository repository;
    private final ApplicationEventPublisher publisher;
    public BaseEntity getEntity(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Transactional
    public void create(BaseEntity entity) {
        BaseEntity baseEntity = new BaseEntity();
        baseEntity.setName(entity.getName());
        baseEntity.setResult(entity.getResult());
        publisher.publishEvent(baseEntity);
        BaseEntity saved = repository.save(entity);
        System.out.println("saved entity^ " + saved.getId());
        if (Math.random() > 0.5) {
            System.out.println("++++++++++++++++++++");
            throw new RuntimeException();
        }
    }

    public Iterable<BaseEntity> getAll() {
        return repository.findAll();
    }
}
