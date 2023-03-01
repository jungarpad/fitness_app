package com.codecool.fitnes_app_workshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Workout {
    private long id;
    private String name, difficulty;
    private int duration;
}