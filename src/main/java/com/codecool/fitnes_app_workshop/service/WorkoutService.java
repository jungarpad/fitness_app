package com.codecool.fitnes_app_workshop.service;

import com.codecool.fitnes_app_workshop.model.Difficulty;
import com.codecool.fitnes_app_workshop.model.Workout;
import com.codecool.fitnes_app_workshop.repository.WorkoutJdbcDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {
    private final WorkoutJdbcDao workoutJdbcDao;

    public WorkoutService(WorkoutJdbcDao workoutJdbcDao) {
        this.workoutJdbcDao = workoutJdbcDao;
    }

    public List<Workout> getWorkoutList() {
        return workoutJdbcDao.getWorkoutList();
    }

    public List<Workout> findWorkouts(String workoutName) {
        return workoutJdbcDao.findWorkouts(workoutName);
    }

    public Optional<Workout> getWorkoutById(long id) {
        return workoutJdbcDao.getWorkoutById(id);
    }

    public boolean addWorkout(String name, String difficulty, int duration) {
        Workout workout = new Workout();
        workout.setName(name);
        workout.setDifficulty(Difficulty.valueOf(difficulty.toUpperCase()));
        workout.setDuration(duration);
        return workoutJdbcDao.addWorkout(workout);
    }

    public boolean deleteWorkout(long id) {
        return workoutJdbcDao.deleteWorkout(id);
    }
}