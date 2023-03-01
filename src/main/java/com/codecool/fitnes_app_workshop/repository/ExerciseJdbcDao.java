package com.codecool.fitnes_app_workshop.repository;

import com.codecool.fitnes_app_workshop.model.Exercise;
import com.codecool.fitnes_app_workshop.repository.mapper.ExerciseMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ExerciseJdbcDao {
    JdbcTemplate template;
    ExerciseMapper mapper;

    public ExerciseJdbcDao(JdbcTemplate template, ExerciseMapper exerciseMapper) {
        this.template = template;
        this.mapper = exerciseMapper;
    }

    public List<Exercise> getExerciseList() {
        String SQL = "SELECT * FROM exercise;";
        return template.query(SQL, mapper);
    }

    public Optional<Exercise> getExercise(long id) {
        String SQL = "SELECT * FROM exercise WHERE id = ?;";
        return template.query(SQL, mapper, id).stream().findFirst();
    }

    public boolean add(Exercise exercise) {
        String SQL = "INSERT INTO exercise (name, muscle_group, calories_burned) VALUES (? , ? , ?);";
        return template.update(SQL, exercise.getName(), exercise.getMuscleGroup().toString(), exercise.getCaloriesBurned()) == 1;
    }

    public boolean delete(long id) {
        String SQL = "DELETE FROM exercise WHERE id = ?;";
        return template.update(SQL, id) == 1;
    }
}
