package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Student;
import com.app.repo.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping
    public ResponseEntity<String> createStudent(@Valid @RequestBody Student student) {
        // Calculate total and average marks
        int totalMarks = student.getMark1() + student.getMark2() + student.getMark3();
        double averageMarks = totalMarks / 3.0;

        // Calculate result based on minimum marks required for each subject
        String result = (student.getMark1() >= 35 && student.getMark2() >= 35 && student.getMark3() >= 35) ? "Pass" : "Fail";

        // Save the student in the database
        studentRepository.save(student);

        return ResponseEntity.ok("Student created successfully. Total Marks: " + totalMarks +
                ", Average Marks: " + averageMarks + ", Result: " + result);
    }
}	