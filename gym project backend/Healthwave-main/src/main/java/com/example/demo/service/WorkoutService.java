package com.example.demo.service;

import com.example.demo.entity.WorkoutEntity;

import java.util.List;

public interface WorkoutService {
    WorkoutEntity saveWorkout(WorkoutEntity workout);
    List<WorkoutEntity> getAllWorkouts();
    WorkoutEntity getWorkoutById(Long id);
    WorkoutEntity updateWorkout(Long id, WorkoutEntity workout);
    void deleteWorkout(Long id);
}
