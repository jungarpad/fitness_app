package com.codecool.fitnes_app_workshop.repository.mapper;

import com.codecool.fitnes_app_workshop.model.Difficulty;
import com.codecool.fitnes_app_workshop.model.Workout;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class WorkoutMapper implements RowMapper<Workout> {
    @Override
    public Workout mapRow(ResultSet rs, int rowNum) throws SQLException {
        Workout workout = new Workout();
        workout.setId(rs.getLong("id"));
        workout.setName(rs.getString("name"));
        workout.setDuration(rs.getInt("duration"));
        workout.setDifficulty(Difficulty.valueOf(rs.getString("difficulty").toUpperCase()));
        return workout;
    }
}
