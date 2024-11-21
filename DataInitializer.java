package com.school_management.school_management;

import com.school_management.school_management.entity.*;
import com.school_management.school_management.repositories.AssignmentRepository;
import com.school_management.school_management.repositories.CourseRepository;
import com.school_management.school_management.repositories.StudentRepository;
import com.school_management.school_management.repositories.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private StudentRepository studentRepository;

    private TeacherRepository teacherRepository;

    private CourseRepository courseRepository;

    private AssignmentRepository assignmentRepository;







    @Override
    public void run(String... args) throws Exception {
        // Create Teachers
        Teacher teacher1 = new Teacher();
        teacher1.setName("Dr. Sarah Connor");
        teacher1.setEmail("sarah.connor@example.com");

        Teacher teacher2 = new Teacher();
        teacher2.setName("Mr. John Wick");
        teacher2.setEmail("john.wick@example.com");

        teacherRepository.saveAll(Arrays.asList(teacher1, teacher2));

        // Create Courses
        Course math = new Course();
        math.setName("Mathematics");
        math.setDescription("Advanced Mathematics Course");
        math.setTeacher(teacher1);

        Course history = new Course();
        history.setName("History");
        history.setDescription("World History Overview");
        history.setTeacher(teacher2);

        Course physics = new Course();
        physics.setName("Physics");
        physics.setDescription("Fundamentals of Physics");
        physics.setTeacher(teacher1);

        courseRepository.saveAll(Arrays.asList(math, history, physics));

        // Create Students
        Student alice = new Student();
        alice.setName("Alice Johnson");
        alice.setEmail("alice@example.com");



        StudentDetail aliceDetail = new StudentDetail();
        aliceDetail.setAddress("123 Maple St, Springfield");
        aliceDetail.setPhoneNumber("555-1234");
        aliceDetail.setStudent(alice);
        alice.setStudentDetail(aliceDetail);

        Student bob = new Student();
        bob.setName("Bob Smith");
        bob.setEmail("bob@example.com");

        StudentDetail bobDetail = new StudentDetail();
        bobDetail.setAddress("456 Elm St, Metropolis");
        bobDetail.setPhoneNumber("555-5678");
        bobDetail.setStudent(bob);
        bob.setStudentDetail(bobDetail);

        Student charlie = new Student();
        charlie.setName("Charlie Brown");
        charlie.setEmail("charlie@example.com");

        StudentDetail charlieDetail = new StudentDetail();
        charlieDetail.setAddress("789 Oak St, Gotham");
        charlieDetail.setPhoneNumber("555-9012");
        charlieDetail.setStudent(charlie);
        charlie.setStudentDetail(charlieDetail);

        studentRepository.saveAll(Arrays.asList(alice, bob, charlie));

        // Assign Courses to Students (Many-to-Many)
        alice.setCourses(Arrays.asList(math, physics));
        bob.setCourses(Arrays.asList(math, history));
        charlie.setCourses(Arrays.asList(history));

        studentRepository.saveAll(Arrays.asList(alice, bob, charlie));

        // Create Assignments
        Assignment calculusHomework = new Assignment();
        calculusHomework.setTitle("Calculus Homework");
        calculusHomework.setDescription("Solve 10 calculus problems.");
        calculusHomework.setCourse(math);

        Assignment essayOnRome = new Assignment();
        essayOnRome.setTitle("Essay on Ancient Rome");
        essayOnRome.setDescription("Write a 1500-word essay.");
        essayOnRome.setCourse(history);

        Assignment physicsLabReport = new Assignment();
        physicsLabReport.setTitle("Physics Lab Report");
        physicsLabReport.setDescription("Complete the lab report for experiment 3.");
        physicsLabReport.setCourse(physics);

        assignmentRepository.saveAll(Arrays.asList(calculusHomework, essayOnRome, physicsLabReport));

        System.out.println("Data initialized successfully!");
    }
}
