package com.example.demoapp.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeResponse getEmployeeById(int id) {
//        EmployeeResponse response = new EmployeeResponse();
//        response.setId(id);
//        response.setName("Kongpop");
        Optional<Employee> result = employeeRepository.findById(id);
        if(result.isPresent()){
            EmployeeResponse response = new EmployeeResponse();
            response.setId(result.get().getId());
            response.setName((result.get().getName()));
            return response;
        }
        throw new EmployeeNotFoundException("Employee not found id="+id);
    }
}
