package com.codecool.fitnes_app_workshop.repository;

import com.codecool.fitnes_app_workshop.model.Exercise;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ExerciseJdbcDao {
    public List<Exercise> getExerciseList() {
        return null;
    }

    public Optional<Exercise> getExercise(long id) {
        return null;
    }

    public boolean add(Exercise exercise) {
        return null;
    }

    public boolean delete(long id) {
        return null;
    }
}
