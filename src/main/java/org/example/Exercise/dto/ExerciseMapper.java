package org.example.Exercise.dto;

import org.example.Exercise.Exercise;
import org.example.Exercise.dto.response.FindExercisesResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ExerciseMapper {
    public FindExercisesResponse toDto(Page<Exercise> exercises, Map<Exercise,List<String>> agonistsMap,Map<Exercise,List<String>> itemsMap, Map<Exercise,Boolean> favoritesMap){
        List<FindExercisesResponse.ExerciseObject> exerciseObjects=
                exercises.stream()
                        .map(exercise -> new FindExercisesResponse.ExerciseObject(exercise.getVideo(),exercise.getDescription(),exercise.getName(),agonistsMap.get(exercise),itemsMap.get(exercise),favoritesMap.get(exercise),exercise.getExperts()))
                        .toList();
        return new FindExercisesResponse(exerciseObjects,exercises.getSize(),exercises.getNumber(),exercises.getTotalPages());
    }
}
