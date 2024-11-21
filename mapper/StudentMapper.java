package com.school_management.school_management.mapper;


import com.school_management.school_management.dto.StudentDto;
import com.school_management.school_management.entity.Student;

public class StudentMapper {

    public static StudentDto toStudentDto(Student student) {
        return StudentDto.builder()
                .id(student.getStudentId())
                .name(student.getName())
                .email(student.getEmail())
                .build();
    }

    public static Student toStudent(StudentDto studentDto) {
        return Student.builder()
                .studentId(studentDto.getId())
                .name(studentDto.getName())
                .build();
    }

}
