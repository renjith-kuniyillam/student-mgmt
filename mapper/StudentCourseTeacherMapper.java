
package com.school_management.school_management.mapper;

import com.school_management.school_management.dto.StudentCourseTeacherDto;
import com.school_management.school_management.entity.Course;
import com.school_management.school_management.entity.Student;
import com.school_management.school_management.entity.Teacher;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentCourseTeacherMapper {
    public static StudentCourseTeacherDto toStudentCourseTeacherDto(Student student, Course course, Teacher teacher) {
        return StudentCourseTeacherDto.builder()
                .studentId(student.getStudentId())
                .studentName(student.getName())
                .courseName(course.getName())
                .teacherName(teacher.getName())
                .build();
    }

}
