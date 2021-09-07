package com.example.demoapp.employees;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerServiceTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private  EmployeeRepository employeeRepository;


    @Test
    @DisplayName("Success case")
    public void caseSuccess(){
//        arrange
        int id=1;
        Employee emp1 = new Employee();
        emp1.setId(1);
        emp1.setName("Kongpop");
        when(employeeRepository.findById(1)).thenReturn(Optional.of(emp1));
//        act
        EmployeeResponse result = restTemplate.getForObject("/employee/"+id,EmployeeResponse.class);
//        assert
        assertEquals("Kongpop",result.getName());

    }

    @Test
    @DisplayName("Failure case : emp id =100")
    public void caseFail(){
//        arrange
        int id=100;
        Employee emp1 = new Employee();
        emp1.setId(1);
        emp1.setName("Kongpop");
        when(employeeRepository.findById(1)).thenReturn(Optional.of(emp1));
//        act
        EmployeeResponse result = restTemplate.getForObject("/employee/"+id,EmployeeResponse.class);
//        assert
        assertNull(result.getName());

    }

    @Test
    @DisplayName("Failure case 2 : emp id =100")
    public void caseFail2(){
//        arrange
        int id=100;
        ResponseEntity<ErrorResponse> result = restTemplate.getForEntity("/employee/"+id,ErrorResponse.class);

//        assert
        assertEquals(404,result.getStatusCodeValue());
        assertEquals(404,result.getBody().getCode());
        assertEquals("Employee not found id="+id,result.getBody().getDetail());

    }
}