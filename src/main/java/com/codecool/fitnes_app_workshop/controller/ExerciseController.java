package com.codecool.fitnes_app_workshop.controller;

import com.codecool.fitnes_app_workshop.model.Exercise;
import com.codecool.fitnes_app_workshop.service.ExerciseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/exercises")
public class ExerciseController {
    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping
    public ResponseEntity<List<Exercise>> getExerciseList() {
        return new ResponseEntity<>(exerciseService.getExerciseList(), HttpStatus.OK);
    }

    public ResponseEntity<Optional<Exercise>> getExercise(long id) {
        Optional<Exercise> maybeExercise = exerciseService.getExercise(id);
        if (maybeExercise.isPresent()) {
            return new ResponseEntity<>(maybeExercise, HttpStatus.FOUND);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> add(String name, int caloriesBurned, String muscleGroup) {
        if (exerciseService.add(name, caloriesBurned, muscleGroup)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> delete(long id) {
        if (exerciseService.delete(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
