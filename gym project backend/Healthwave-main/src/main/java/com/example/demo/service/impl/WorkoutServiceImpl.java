package com.example.demo.service.impl;

import com.example.demo.entity.WorkoutEntity;
import com.example.demo.repository.WorkoutRepository;
import com.example.demo.service.WorkoutService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutServiceImpl implements WorkoutService {

    private final WorkoutRepository workoutRepository;

    public WorkoutServiceImpl(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @Override
    public WorkoutEntity saveWorkout(WorkoutEntity workout) {
        return workoutRepository.save(workout);
    }

    @Override
    public List<WorkoutEntity> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    @Override
    public WorkoutEntity getWorkoutById(Long id) {
        return workoutRepository.findById(id).orElseThrow(() -> new RuntimeException("Workout not found"));
    }

    @Override
    public WorkoutEntity updateWorkout(Long id, WorkoutEntity workout) {
        WorkoutEntity existingWorkout = workoutRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workout not found"));
        
        existingWorkout.setTitle(workout.getTitle());
        existingWorkout.setTarget(workout.getTarget());
        existingWorkout.setVideoLink(workout.getVideoLink());
        
        return workoutRepository.save(existingWorkout);
    }

    @Override
    public void deleteWorkout(Long id) {
        WorkoutEntity workout = workoutRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workout not found"));
        workoutRepository.delete(workout);
    }
}
