package com.example.demoapp.employees;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceUnitTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    public void caseSuccess(){
        //arrange
        Employee emp1 = new Employee();
        emp1.setId(1);
        emp1.setName("Mock");
        when(employeeRepository.findById(1)).thenReturn(Optional.of(emp1));
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        //act
        EmployeeResponse result = employeeService.getEmployeeById(1);
        //assert
        assertEquals(1,result.getId());
        assertEquals("Mock",result.getName());
    }

    @Test
    public void employee_not_found_case(){
        //arrange
        int id=1;
        when(employeeRepository.findById(id)).thenReturn(Optional.empty());
        //act
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        try {
            EmployeeResponse res = employeeService.getEmployeeById(id);
            fail();
        }catch(EmployeeNotFoundException e){
            //pass
            if(!("Employee not found id="+id).equals(e.getMessage())){
                fail("Message fail with : "+e.getMessage());
            }
        }
    }

    @Test
    public void employee_not_found_case_with_junit5(){
        //arrange
        int id=1;
        when(employeeRepository.findById(id)).thenReturn(Optional.empty());
        //act
        EmployeeService employeeService = new EmployeeService(employeeRepository);
       Exception exception = assertThrows(EmployeeNotFoundException.class,()->{
           employeeService.getEmployeeById(id);
       });
       assertEquals("Employee not found id="+id,exception.getMessage());
    }
}
