package org.example.Employee.dto;

import lombok.NoArgsConstructor;
import org.example.Avatar.Avatar;
import org.example.Employee.Employee;
import org.example.Employee.dto.response.FindEmployeeResponse;
import org.example.Employee.dto.response.FindTopEmployeesResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor
public class EmployeeMapper {
    public FindTopEmployeesResponse toDtoTopEmployees(List<Employee> employees, Map<Employee,String> names){
        FindTopEmployeesResponse findTopEmployeesResponse =new FindTopEmployeesResponse();
        List<FindTopEmployeesResponse.EmployeeTop> top=employees.stream().map(e->
            new FindTopEmployeesResponse.EmployeeTop(e.getLogin(),e.getActivity(),e.getExperts(),names.get(e))).toList();
        findTopEmployeesResponse.setTop(top);
        return findTopEmployeesResponse;
    }
    public FindEmployeeResponse toDtoEmployee(Map<Employee,String> avatar,Long top){
        return  avatar.entrySet().stream().findFirst().map(a->
              new FindEmployeeResponse(
                     a.getKey().getLogin(),a.getValue(),a.getKey().getExperts(),a.getKey().getActivity(),top
             )
         ).orElse(null);
    }
    public Map<Employee, Avatar> toMapEmployee(List<Employee> employees){
        return employees.stream().collect(Collectors.toMap(e->e,Employee::getAvatar));
    }
}
