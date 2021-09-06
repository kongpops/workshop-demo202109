package com.example.demoapp.employees;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping("/employees")
    public EmployeeResponse[] listEmployee(){
        EmployeeResponse emp01 = new EmployeeResponse();
        emp01.setId(1);
        emp01.setName("Kongpop");
        EmployeeResponse emp02 = new EmployeeResponse();
        emp02.setId(2);
        emp02.setName("mike");
        return new EmployeeResponse[]{emp01,emp02};
    }

    @GetMapping("/employee/{id}")
    public EmployeeResponse geyEmployeeById(@PathVariable(name ="id") String id){
//        Vailidate input
//        Cleaning data
        EmployeeResponse emp01 = new EmployeeResponse();
        emp01.setId(Integer.parseInt(id));
        emp01.setName("Kongpop");
        return emp01;
    }
}
