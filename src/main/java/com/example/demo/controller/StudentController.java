package com.example.demo.controller;

import com.example.demo.model.input.StudentInput;
import com.example.demo.model.output.StudentOutput;
import com.example.demo.service.StudentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping(
            value = "/process",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public StudentOutput process(@RequestBody StudentInput input) {
        return service.processStudent(input);
    }
}
