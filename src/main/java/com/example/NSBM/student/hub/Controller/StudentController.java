package com.example.NSBM.student.hub.Controller;

import com.example.NSBM.student.hub.model.Student;
import com.example.NSBM.student.hub.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {


    @Autowired
    private StudentService service;


    @GetMapping
    public Page<Student> getAll(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        return service.getAll(page, size, sortBy);
    }


    @PostMapping
    public Student create(@RequestBody Student student) {
        return service.save(student);
    }


    @GetMapping("/{id}")
    public Student get(@PathVariable Long id) {
        return service.getById(id);
    }
}
