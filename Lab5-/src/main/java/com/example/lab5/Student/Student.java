package com.example.lab5.Student;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private String ID;
    private String name;
    private int age;
    private double degree;
    private double GPA;
}
