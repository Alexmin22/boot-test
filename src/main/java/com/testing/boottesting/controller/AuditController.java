package com.testing.boottesting.controller;

import com.testing.boottesting.entity.AuditEntity;
import com.testing.boottesting.entity.BaseEntity;
import com.testing.boottesting.service.HttpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/audit")
@RequiredArgsConstructor
public class AuditController {

    private final AuditService auditService;
    private final HttpService httpService;

    @GetMapping("/{id}")
    public ResponseEntity<AuditEntity> getEntityById(@PathVariable long id) {
        return ok(auditService.getEntity(id));
    }

    @PostMapping
    public void create(@RequestBody BaseEntity entity) {
        auditService.createAudit(entity);
    }

    @GetMapping("/name")
    public String getThreadName() {
        return Thread.currentThread().toString();
    }

    @GetMapping("/service")
    public List<String> getService() {
        List<URI> uris = List.of(
            URI.create("https://jsonplaceholder.typicode.com/posts/1"),
            URI.create("https://jsonplaceholder.typicode.com/posts/2"),
            URI.create("https://jsonplaceholder.typicode.com/posts/3")
        );

        return httpService.fetchDataFromSources(uris);
    }

    @GetMapping
    public ResponseEntity<Iterable<AuditEntity>> getAll() {
        return ok(auditService.getAll());
    }
}
