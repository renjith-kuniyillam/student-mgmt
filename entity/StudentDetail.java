package com.school_management.school_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "student_details")
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentDetailId;

    private String address;

    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
}