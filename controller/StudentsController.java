package com.school_management.school_management.controller;

import com.school_management.school_management.service.CourcesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentsController {

    private final CourcesService courcesService;


    @GetMapping("/byCourse/{course}")
    public ResponseEntity<Object> getStudentsOfCourse(@PathVariable(name="course") String courseName) {
        courcesService.getStudentsByCourse(courseName);
        return ResponseEntity.ok(courcesService.getStudentsByCourse(courseName));
    }

    @GetMapping("/byCourseAndName/{course}/{name}")
    public ResponseEntity<Object> getStudentsOfCourseAndName(@PathVariable(name="course") String courseName, @PathVariable(name="name") String studentName) {
        return ResponseEntity.ok(courcesService.getStudentsByNameAndCourse(studentName, courseName));
    }
}
