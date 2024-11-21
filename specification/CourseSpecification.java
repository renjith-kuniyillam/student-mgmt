package com.school_management.school_management.specification;

import com.school_management.school_management.entity.Course;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class CourseSpecification {
    public static Specification<Course> courseNameLike(String courseName) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + courseName + "%");
    }

    public static Specification<Course> studentNameLike(String studentName) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.join("students").get("name"), "%" + studentName + "%");
    }


}
