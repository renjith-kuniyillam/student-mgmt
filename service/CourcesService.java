package com.school_management.school_management.service;

import com.school_management.school_management.dto.StudentCourseTeacherDto;
import com.school_management.school_management.dto.StudentDto;
import com.school_management.school_management.entity.Course;
import com.school_management.school_management.entity.Student;
import com.school_management.school_management.mapper.StudentCourseTeacherMapper;
import com.school_management.school_management.mapper.StudentMapper;
import com.school_management.school_management.repositories.CourseRepository;
import com.school_management.school_management.specification.CourseSpecification;
import com.school_management.school_management.specification.StudentSpecification;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.rsocket.RSocketProperties;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CourcesService {

    private final CourseRepository courcesRepository;

    // Method to get students by course name
    public List<StudentDto> getStudentsByCourse(String courseName) {
        Specification<Course> courseSpecification = CourseSpecification.courseNameLike(courseName);


         List<Course> result = courcesRepository.findAll(courseSpecification);
        System.out.println(result);
        List<StudentDto> studentDtoList = result.stream()
                .flatMap(x -> x.getStudents().stream())
                .map(StudentMapper::toStudentDto)
                .collect(Collectors.toList());
        return studentDtoList;
    }

    public List<StudentCourseTeacherDto> getStudentsByNameAndCourse(String studentName, String courseName) {
//        Specification<Course> courseSpecification = Specification
//                .where(CourseSpecification.courseNameLike(courseName))
//                .and(CourseSpecification.studentNameLike(studentName));
        Specification<Course> courseSpecification = CourseSpecification.studentNameAndCourseNameLike(studentName, courseName);

//        Specification<Course> spec = Specification
//                .where(CourseSpecification.courseNameLike(courseName))
//                .and(CourseSpecification.fetchStudents());
        List<Course> result = courcesRepository.findAll(courseSpecification);
        List<StudentCourseTeacherDto> studentDtoList = new ArrayList<>();

//                .flatMap(x -> x.getStudents().stream())
//                .filter(student -> student.getName().contains(studentName))
//                .map(y-> StudentCourseTeacherMapper.toStudentCourseTeacherDto(y, x.getCourse(), y.getTeacher()))
//                .collect(Collectors.toList());

        for(Course x : result){
            for(Student y : x.getStudents()){
                if(y.getName().contains(studentName)){
                    studentDtoList.add(StudentCourseTeacherMapper.toStudentCourseTeacherDto(y, x, x.getTeacher()));
                }
            }
        }

        return studentDtoList;
 //       return studentDtoList;
    }










}
