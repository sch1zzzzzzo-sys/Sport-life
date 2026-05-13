package org.example.Employee.UseCase;

import lombok.RequiredArgsConstructor;
import org.example.Avatar.Avatar;
import org.example.Avatar.Service.AvatarService;
import org.example.Employee.Employee;
import org.example.Employee.Service.EmployeeService;
import org.example.Employee.dto.request.CreateEmployeeRequest;
import org.example.Employee.dto.response.CreateEmployeeResponse;
import org.example.Security.AuthClass;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateEmployee {
    private final EmployeeService employeeService;
    private final AvatarService avatarService;
    private final AuthClass authClass;

    public CreateEmployeeResponse createEmployee(CreateEmployeeRequest dto){
        Avatar avatar=avatarService.findAvatarByName("https://i.pinimg.com/originals/5f/91/41/5f91413c8a9e766a5139c6cfe5caa837.jpg?nii=t");
        Employee employee= employeeService.createEmployee(dto.getLogin(), dto.getPassword(),avatar);
        String token=authClass.createToken(employee.getLogin());
        String refreshToken=authClass.createRefresh(employee.getLogin());
        return new CreateEmployeeResponse(token, refreshToken);
    }
}
