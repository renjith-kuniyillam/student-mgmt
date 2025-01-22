package com.school_management.school_management.service;

import com.school_management.school_management.dto.StudentDetailsDto;
import com.school_management.school_management.entity.Student;
import com.school_management.school_management.mapper.StudentDetailsDtoMapper;
import com.school_management.school_management.repositories.StudentRepository;
import com.school_management.school_management.specification.StudentSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<StudentDetailsDto> getStudentDetails(String studentName) {
        Specification<Student> studentSpecification = StudentSpecification.studentWithCourseAndTeacher(studentName);
        List<Student> result = studentRepository.findAll(studentSpecification);

        List<StudentDetailsDto> studentDetailsDtoList = result.stream()
                .map(StudentDetailsDtoMapper::toStudentDetailsDto)
                .toList();

        return studentDetailsDtoList;
    }

}
