package com.school_management.school_management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentCourseTeacherDto {
    private long studentId;
    private String studentName;
    private String courseName;
    private String teacherName;
}
