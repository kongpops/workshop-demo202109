package com.example.demoapp.employees;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerWebMVCTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void getEmployById() throws Exception {
        int id =1 ;
        //arrange
        EmployeeResponse emp = new EmployeeResponse();
        emp.setId(id);
        emp.setName("Mockname");
        when(employeeService.getEmployeeById(1)).thenReturn(emp);

        MvcResult result = mockMvc.perform(get("/employee/"+id)).andExpect(status().isOk()).andReturn();
        byte[] json = result.getResponse().getContentAsByteArray();
        ObjectMapper mapper = new ObjectMapper();
        EmployeeResponse response = mapper.readValue(json,EmployeeResponse.class);
        assertEquals(id , response.getId());
        assertEquals("Kongpop",response.getName());

    }
}
