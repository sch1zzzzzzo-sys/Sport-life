package org.example.Employee.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthEmployeeRequest {
    @NotBlank(message = "login не может быть пустым")
    private String login;
    @NotBlank(message = "пароль не может быт пустым")
    private String password;
}
