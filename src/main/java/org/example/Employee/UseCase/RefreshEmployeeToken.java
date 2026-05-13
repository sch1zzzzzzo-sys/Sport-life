package org.example.Employee.UseCase;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.Employee.dto.request.RefreshEmployeeTokenRequest;
import org.example.Employee.dto.response.RefreshEmployeeTokenResponse;
import org.example.Security.AuthClass;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Data
@Service
public class RefreshEmployeeToken {
    private final AuthClass authClass;
    public RefreshEmployeeTokenResponse refresh(RefreshEmployeeTokenRequest dto){
        String tokenRefresh=dto.getTokenRefresh();
        RefreshEmployeeTokenResponse response=new RefreshEmployeeTokenResponse();
        String tokenAccess;
        if(authClass.validetTokenRefresh(tokenRefresh)){
            String login=authClass.getLoginRefresh(tokenRefresh);
            tokenAccess=authClass.createToken(login);
            response=new RefreshEmployeeTokenResponse(tokenAccess,tokenRefresh);
        }else {
            response=null;
        }
        return response;
    }
}
