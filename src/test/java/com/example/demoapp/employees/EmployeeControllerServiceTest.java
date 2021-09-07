package com.example.demoapp.employees;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerServiceTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private  EmployeeRepository employeeRepository;


    @Test
    @DisplayName("Success case")
    public void getEmpById(){
//        arrange
        int id=1;
        Employee emp1 = new Employee();
        emp1.setId(1);
        emp1.setName("Kongpop");
        when(employeeRepository.findById(1)).thenReturn(Optional.of(emp1));
//        act
        EmployeeResponse emp = restTemplate.getForObject("/employee/"+id,EmployeeResponse.class);
//        assert
        assertEquals("Kongpop",emp.getName());

    }
}