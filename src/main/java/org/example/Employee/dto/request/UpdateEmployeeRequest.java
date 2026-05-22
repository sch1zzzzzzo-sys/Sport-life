package org.example.Employee.dto.request;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeRequest {
    @Pattern(regexp = "^(?!\\s*$).+",message = "Имя не может быть пустым или состоять из пробелов")
    @Size(min =3,max = 20,message = "имя не должно быть короче 3 или длиннее 20 символов")
    private String login;
    @Pattern(regexp = "^(?!\\s*$).+",message = "")
    private String avatar;
}
