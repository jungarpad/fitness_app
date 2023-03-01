package com.codecool.fitnes_app_workshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Exercise {
    private long id;
    private String name;
    private MuscleGroup muscleGroup;
    private int caloriesBurned;

}