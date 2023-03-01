package com.codecool.fitnes_app_workshop.repository;

import com.codecool.fitnes_app_workshop.model.Workout;
import com.codecool.fitnes_app_workshop.repository.mapper.WorkoutMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class WorkoutJdbcDao {
    private final JdbcTemplate template;
    private final WorkoutMapper mapper;

    public WorkoutJdbcDao(JdbcTemplate template, WorkoutMapper mapper) {
        this.template = template;
        this.mapper = mapper;
    }

    public List<Workout> getWorkoutList() {
        String SQL = "SELECT * FROM workout;";
        return template.query(SQL, mapper);
    }

    public List<Workout> findWorkouts(String workoutName) {
        String SQL = "SELECT * FROM workout WHERE name ilike '%?%';";
        return template.query(SQL, mapper, workoutName);
    }

    public Optional<Workout> getWorkoutById(long id) {
        String SQL = "SELECT * FROM workout WHERE id=?;";
        return template.query(SQL, mapper, id).stream().findFirst();
    }

    public boolean addWorkout(Workout workout) {
        String SQL = "INSERT INTO workout(name, duration, difficulty) VALUES (?, ?, ?);";
        return template.update(SQL, workout.getName(), workout.getDuration(), workout.getDifficulty().toString()) == 1;
    }

    public boolean deleteWorkout(long id) {
        String SQL = "DELETE FROM workout WHERE id = ?;";
        return template.update(SQL, id) == 1;
    }
}
