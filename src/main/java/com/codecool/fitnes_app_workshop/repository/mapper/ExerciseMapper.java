package com.codecool.fitnes_app_workshop.repository.mapper;

import com.codecool.fitnes_app_workshop.model.Exercise;
import com.codecool.fitnes_app_workshop.model.MuscleGroup;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ExerciseMapper implements RowMapper<Exercise> {
    @Override
    public Exercise mapRow(ResultSet rs, int rowNum) throws SQLException {
        Exercise exercise = new Exercise();
        exercise.setId(rs.getLong("id"));
        exercise.setName(rs.getString("name"));
        exercise.setMuscleGroup(MuscleGroup.valueOf(rs.getString("muscle_group").toUpperCase()));
        return exercise;
    }
}
