package com.codecool.fitnes_app_workshop.controller;

import com.codecool.fitnes_app_workshop.model.Workout;
import com.codecool.fitnes_app_workshop.service.WorkoutService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {
    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping
    public ResponseEntity<List<Workout>> getWorkoutList() {
        return new ResponseEntity<>(workoutService.getWorkoutList(), HttpStatus.OK);
    }

    @GetMapping("/{search_term}")
    public List<Workout> findWorkouts(@PathVariable("search_term") String workoutName) {
        return workoutService.findWorkouts(workoutName);
    }

    @GetMapping("/{id}")
    public Optional<Workout> getWorkoutById(@PathVariable long id) {
        return workoutService.getWorkoutById(id);
    }

    @PostMapping
    public ResponseEntity addWorkout(@RequestBody WorkoutDTO request) {

        if (workoutService.addWorkout(request.name(), request.difficulty(), request.duration())) {
            return new ResponseEntity(HttpStatus.CREATED);
        } else return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public boolean deleteWorkout(@PathVariable long id) {
        return workoutService.deleteWorkout(id);
    }
}

record WorkoutDTO(String name, String difficulty, int duration) {
}