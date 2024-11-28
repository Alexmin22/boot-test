package com.testing.boottesting.controller;

import com.testing.boottesting.entity.BaseEntity;
import com.testing.boottesting.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BaseController {

    private final BaseService baseService;

    @GetMapping("/{id}")
    public ResponseEntity<BaseEntity> getEntityById(@PathVariable long id) {
        return ok(baseService.getEntity(id));
    }

    @PostMapping
    public void create(@RequestBody BaseEntity entity) {
            baseService.create(entity);
    }

    @PostMapping("/file")
    public String metodC(@RequestPart MultipartFile file) {
        return String.format("originalName=%s, name=%s", file.getOriginalFilename(), file.getName());
    }

    @GetMapping
    public ResponseEntity<Iterable<BaseEntity>> getAll() {
        return ok(baseService.getAll());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        // Логирование или какое-то другое действие
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("Произошла ошибка: " + ex.getMessage());
    }
}
