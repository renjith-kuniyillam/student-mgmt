package com.school_management.school_management.specification;

import com.school_management.school_management.entity.Course;
import com.school_management.school_management.entity.Student;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class CourseSpecification {
    public static Specification<Course> courseNameLike(String courseName) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("name"), "%" + courseName + "%");
        };
    }

    public static Specification<Course> fetchStudents() {
        return (root, query, criteriaBuilder) -> {
            root.join("students", JoinType.LEFT);  // Join students but not others
            return criteriaBuilder.conjunction();
        };
    }

    public static Specification<Course> studentNameLike(String studentName) {
        return (root, query, criteriaBuilder) -> {
            var studentsJoin = root.fetch("students", JoinType.INNER);
            return criteriaBuilder.like(root.join("students").get("name"), "%" + studentName + "%");
        };
    }

    public static Specification<Course> studentNameAndCourseNameLike(String studentName, String courseName) {
        return (root, query, criteriaBuilder) -> {
            query.distinct(true); // Ensure distinct results
            var studentsJoin = root.join("students", JoinType.INNER);
            return criteriaBuilder.or(
                    criteriaBuilder.like(studentsJoin.get("name"), "%" + studentName + "%"),
                    criteriaBuilder.like(root.get("name"), "%" + courseName + "%")
            );
        };
    }


}
