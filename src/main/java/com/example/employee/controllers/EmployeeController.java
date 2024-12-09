package com.example.employee.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.employee.services.EmployeeTransformer;
import javax.xml.transform.TransformerException;
import java.io.IOException;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeTransformer employeeTransformer;
    @GetMapping("/")
    public String showForm() {
        return "transform";
    }
    @PostMapping("/transform")
    public String getTransformedEmployeeXml(Model model) {
        try {
            String transformedXml = employeeTransformer.transformEmployeeXml();
            model.addAttribute("transformedXml", transformedXml);
            return "transform";
        } catch (TransformerException | IOException e) {
            model.addAttribute("error", "Error during transformation: " + e.getMessage());
            return "error";
        }
    }
}
