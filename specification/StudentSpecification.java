package com.school_management.school_management.specification;

import com.school_management.school_management.entity.Student;
import org.springframework.data.jpa.domain.Specification;

public class StudentSpecification {
    public static Specification<Student> hasName(String name) {
        return (root, query, cb) -> cb.equal(root.get("name"), name);
    }
}
