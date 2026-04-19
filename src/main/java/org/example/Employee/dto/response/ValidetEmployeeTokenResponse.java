package org.example.Employee.dto.response;

import jakarta.annotation.security.DenyAll;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ValidetEmployeeTokenResponse {
    private Boolean validatedToken;
}
