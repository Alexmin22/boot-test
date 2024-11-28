package com.testing.boottesting.employee;

import jakarta.validation.Valid;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @PostMapping("/new")
    public Employee createEmployee(@RequestBody @Valid Employee employee) {
        return Employee.of(employee.getName(), employee.getMails());
    }

    @GetMapping
    public Employee getEmployee(@RequestParam String name) {
        return Employee.of(name, Collections.emptyList());
    }

    @GetMapping("/consumer")
    public String getEmployeeConsumer(@RequestParam(required = false) String naming) {
        return validateName(naming, name -> (isNotName(name) && isShortName(name)));
    }

    private String validateName(@Nullable String name, Predicate<String> predicate) {
        if(Math.random() > 0.5) {
            return predicate.test(name) ? name.toUpperCase() : "not valid";
        } else {
            return "Не зашли в методы!!";
        }
    }

    private boolean isShortName(@Nullable String name) {
        System.out.println("isShortName...");
        return name != null && name.length() < 3;
    }

    private boolean isNotName(@Nullable String name) {
        System.out.println("isNotName...");
        return name != null && !name.isBlank();
    }
}
