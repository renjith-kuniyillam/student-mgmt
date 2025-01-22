package com.school_management.school_management.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseDetailsDto {
    private String courseName;
    private String teacherName;
}
