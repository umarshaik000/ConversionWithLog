package com.example.demo.service;

import com.example.demo.model.input.StudentInput;
import com.example.demo.model.output.StudentOutput;

public interface StudentService {
    StudentOutput processStudent(StudentInput input);
}
