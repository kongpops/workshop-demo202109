package com.example.demoapp.employees;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private  EmployeeRepository employeeRepository;

    @Test
    public void listEmployee() {
        //Act
        EmployeeResponse emp[] =  restTemplate.getForObject("/employees",EmployeeResponse[].class);

        //Assert
        assertEquals(2,emp.length);
    }

    @Test
    public void getEmpById(){
//        arrange
        int id=1;
        Employee emp01 = new Employee();
        emp01.setName("Kongpop");
        employeeRepository.save(emp01);
//        act
        EmployeeResponse emp = restTemplate.getForObject("/employee/"+id,EmployeeResponse.class);
//        assert
        assertEquals("Kongpop",emp.getName());

    }
}