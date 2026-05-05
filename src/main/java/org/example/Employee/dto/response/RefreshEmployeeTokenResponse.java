package org.example.Employee.dto.response;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RefreshEmployeeTokenResponse extends EmployeeRegistrationDetails{
    public RefreshEmployeeTokenResponse(String accessToken,String refreshToken){
        super(accessToken,refreshToken);

    }
}
