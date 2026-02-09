package com.example.NSBM.student.hub.repository;

import com.example.NSBM.student.hub.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
