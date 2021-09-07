package com.example.demoapp.employees;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    @DisplayName("find by id = 100")
    public void case01(){
//        arrange
        Employee emp100 = new Employee();
        emp100.setName("Mock name");
        employeeRepository.save(emp100);
//        act
        Optional<Employee> result = employeeRepository.findById(1);
//        assert
        assertTrue(result.isPresent());
        assertEquals(1,result.get().getId());
        assertEquals("Mock name",result.get().getName());

//        if(result.isPresent()){
//
//         }
    }

    @Test
    @DisplayName("ค้นหาข้อมูล employee id =1 ไม่เจอ")
    public void case02(){
//        act
        Optional<Employee> result = employeeRepository.findById(1);
//        assert
        assertFalse(result.isPresent());

    }
}