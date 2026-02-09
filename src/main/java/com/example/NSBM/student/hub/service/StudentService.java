package com.example.NSBM.student.hub.service;

import com.example.NSBM.student.hub.model.Student;
import com.example.NSBM.student.hub.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Page<Student> getAll(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return studentRepository.findAll(pageable);
    }
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Student getById(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
