package com.example.demo.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Students")
public class Student {
    @Id
    private String email;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "marks")
    private Double marks;

    @Column(name = "gender")
    private Boolean gender;

    @Column(name = "country")
    private String country;
}
