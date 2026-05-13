package org.example.Employee.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeExpertsRequest {
    @NotBlank(message = "экспертность не может быть пустой")
    private String experts;
}
