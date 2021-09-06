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

    @Test
    public void listEmployee() {
        //Act
        EmployeeResponse emp[] =  restTemplate.getForObject("/employees",EmployeeResponse[].class);

        //Assert
        assertEquals(2,emp.length);
    }

    @Test
    public void getEmp(){
//        act
        EmployeeResponse emp = restTemplate.getForObject("/employee/1",EmployeeResponse.class);
//        assert
        assertEquals("Kongpop",emp.getName());

    }
}