package com.codecool.fitnes_app_workshop.controller;

import com.codecool.fitnes_app_workshop.model.Workout;
import com.codecool.fitnes_app_workshop.service.WorkoutService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Log4j2
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

    @GetMapping("q=")
    public List<Workout> findWorkouts(@RequestParam("q") String workoutName) {
        log.info("Get param {}", workoutName);
        return workoutService.findWorkouts(workoutName);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Workout>> getWorkoutById(@PathVariable long id) {
        Optional<Workout> maybeWorkout = workoutService.getWorkoutById(id);
        if (maybeWorkout.isPresent()) {
            return new ResponseEntity<>(maybeWorkout, HttpStatus.FOUND);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> addWorkout(@RequestBody WorkoutDTO request) {

        if (workoutService.addWorkout(request.name(), request.difficulty(), request.duration())) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWorkout(@PathVariable long id) {
        if (workoutService.deleteWorkout(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}

record WorkoutDTO(String name, String difficulty, int duration) {
}