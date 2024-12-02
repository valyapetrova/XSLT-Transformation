package com.example.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeTransformer employeeTransformer;

    @GetMapping("/transform")
    public String getTransformedEmployeeXml() {
        try {
            return employeeTransformer.transformEmployeeXml();
        } catch (Exception e) {
            return "Error during transformation: " + e.getMessage();
        }
    }
}
