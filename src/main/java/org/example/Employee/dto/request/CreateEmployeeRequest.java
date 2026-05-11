package org.example.Employee.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeRequest {
    @NotBlank(message = "не может быть пустым")
    @Size(min = 3,message = "длинна login не может быт меньше 3 символов")
    private String login;
    @NotBlank(message = "пароль не может быть пустым")
    @Size(min = 8,max = 20,message = "пароль не должен быть короче 8 и длиннее 20 символов ")
    private String password;
}
