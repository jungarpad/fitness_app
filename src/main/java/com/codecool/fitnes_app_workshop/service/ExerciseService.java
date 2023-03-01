package com.codecool.fitnes_app_workshop.service;

import com.codecool.fitnes_app_workshop.model.Exercise;
import com.codecool.fitnes_app_workshop.model.MuscleGroup;
import com.codecool.fitnes_app_workshop.repository.ExerciseJdbcDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService {
    private final ExerciseJdbcDao exerciseJdbcDao;

    public ExerciseService(ExerciseJdbcDao exerciseJdbcDao) {
        this.exerciseJdbcDao = exerciseJdbcDao;
    }

    public List<Exercise> getExerciseList() {
        return exerciseJdbcDao.getExerciseList();
    }

    public Optional<Exercise> getExercise(long id) {
        return exerciseJdbcDao.getExercise(id);
    }

    public boolean add(String name, int caloriesBurned, String muscleGroup) {
        Exercise exercise = Exercise.builder()
                .name(name)
                .caloriesBurned(caloriesBurned)
                .muscleGroup(MuscleGroup.valueOf(muscleGroup.toUpperCase()))
                .build();

        return exerciseJdbcDao.add(exercise);
    }

    public boolean delete(long id) {
        return exerciseJdbcDao.delete(id);
    }
}
