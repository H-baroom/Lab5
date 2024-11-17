package com.example.lab53.event;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;


@Data
@AllArgsConstructor
public class Event {
    private String ID;
    private String description;
    private int capacity;
    private LocalDate startDate;
    private LocalDate endDate;
}
