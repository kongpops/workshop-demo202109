package com.example.demoapp.employees;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerFailureTest {


    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private  EmployeeRepository employeeRepository;


    @Test
    @DisplayName("เกิด error 404 เมื่อค้นหาข้อมูล employee id =1 ไม่เจอ")
    public void case01(){
//        arrange
        int id=1;
//        act
        ErrorResponse res = restTemplate.getForObject("/employee/"+id,ErrorResponse.class);
//        assert
        assertEquals(404,res.getCode());

    }
}
