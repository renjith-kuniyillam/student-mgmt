package com.school_management.school_management.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDto {
    public long id;
    public String name;
    public String email;
    public String courseName;
}
