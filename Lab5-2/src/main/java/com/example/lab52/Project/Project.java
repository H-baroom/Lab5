package com.example.lab52.Project;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Project {
    private String ID;
    private String title;
    private String description;
    private String status;
    private String companyName;
}
