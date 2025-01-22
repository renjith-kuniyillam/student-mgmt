package com.school_management.school_management.mapper;

import com.school_management.school_management.dto.CourseDetailsDto;
import com.school_management.school_management.dto.StudentDetailsDto;
import com.school_management.school_management.entity.Student;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
public class StudentDetailsDtoMapper {
    public static StudentDetailsDto toStudentDetailsDto(Student student) {

        List<CourseDetailsDto> courseDetailsDtoList = Optional.ofNullable(student.getCourses())
                .map(courses -> {
                    return courses.stream().map(course -> {
                        return CourseDetailsDto.builder()
                                .courseName(course.getName())
                                .teacherName(course.getTeacher().getName())
                                .build();
                    }).toList();
                }).orElse(null);


//                student.getCourses().stream().map(course -> {
//            return CourseDetailsDto.builder()
//                    .courseName(course.getName())
//                    .teacherName(course.getTeacher().getName())
//                    .build();
//        }).toList();

        return StudentDetailsDto.builder()
                .courseDetailsDto(courseDetailsDtoList)
                .id(student.getStudentId())
                .name(student.getName())
                .email(student.getEmail())
                .build();

    }

}
