package com.testing.boottesting.employee;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Employee {

    @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotEmpty(message = "Mails cannot be empty")
    private List<String> mails;

    private Employee(String name, List<String> mails) {
        this.name = name;
        this.mails = mails;
    }

    public static Employee of(String name, List<String> mails) {
        return new Employee(name, mails);
    }
}
