package org.example.Employee.UseCase;

import lombok.RequiredArgsConstructor;
import org.example.Employee.dto.request.ValidetEmployeeTokenRequest;
import org.example.Employee.dto.response.ValidetEmployeeTokenResponse;
import org.example.Security.AuthClass;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValidetEmployeeToken {
    private final AuthClass authClass;
    public ValidetEmployeeTokenResponse validet(ValidetEmployeeTokenRequest dto){
        Boolean valid = null;
        if(dto.getType().equals("Refresh")){
            valid=authClass.validetTokenRefresh(dto.getToken());
        }
        return new ValidetEmployeeTokenResponse(valid);
    }
}
