package com.codecool.fitnes_app_workshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Exercise {
    private long id;
    private String name;
    private MuscleGroup muscleGroup;
    private int caloriesBurned;

    public Exercise(String name, MuscleGroup muscleGroup, int caloriesBurned) {
        this.name = name;
        this.muscleGroup = muscleGroup;
        this.caloriesBurned = caloriesBurned;
    }
}