package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    private String name;
    private Boolean gender;
    private Double marks;
    private Contact contact;
    private List<String> subject;
}
