package com.school_management.school_management.repositories;

import com.school_management.school_management.entity.StudentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentDetailRepository extends JpaRepository<StudentDetail, Long>, JpaSpecificationExecutor<StudentDetail> {
}
