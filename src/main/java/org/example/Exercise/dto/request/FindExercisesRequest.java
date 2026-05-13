package org.example.Exercise.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindExercisesRequest {
    @NotEmpty(message = "выберете хотя бы одну мышцу")
    private List<@NotBlank(message = "мышца не может быть пустой") String> muscles;
    @NotEmpty(message = "выберет хотя бы один инвентарь")
    private List<@NotBlank(message = "инвентарь не может быть пустым") String> items;
}
