package com.example.demo.service;

import com.example.demo.exception.InvalidRequestException;
import com.example.demo.exception.InvalidAgeException;
import com.example.demo.exception.InvalidGenderException;
import com.example.demo.model.input.StudentInput;
import com.example.demo.model.output.StudentOutput;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class StudentServiceImpl implements StudentService {

    private static final Logger successLog = LoggerFactory.getLogger("SUCCESS_LOG");

    @Override
    public StudentOutput processStudent(StudentInput input) {

        // ❌ Name validation
        if (input.getName() == null || input.getName().isBlank()) {
            throw new InvalidRequestException("Name is mandatory");
        }

        // ❌ Age validation
        if (input.getAge() <= 0 || input.getAge() > 120) {
            throw new InvalidAgeException("Age must be between 1 and 120");
        }

        // ❌ Gender validation
        if (!"Male".equalsIgnoreCase(input.getGender())
                && !"Female".equalsIgnoreCase(input.getGender())) {
            throw new InvalidGenderException("Gender must be Male or Female");
        }

        String greeting = "Hello " + input.getName() + ", processed successfully!";
        StudentOutput output =
                new StudentOutput(greeting, LocalDateTime.now().toString());

        // ✅ SUCCESS LOG GOES HERE
        successLog.info(
                "Endpoint=/student/process, Input={}, Output={}",
                input,
                output
        );

        return output;
    }
}
