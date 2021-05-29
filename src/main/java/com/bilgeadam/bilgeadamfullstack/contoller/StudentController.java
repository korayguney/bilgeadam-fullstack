package com.bilgeadam.bilgeadamfullstack.contoller;

import com.bilgeadam.bilgeadamfullstack.model.Student;
import com.bilgeadam.bilgeadamfullstack.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
@AllArgsConstructor
public class StudentController {

    public final StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents(){
        List<Student> studentList = studentService.getAllStudents();
        return studentList;
    }

    @PostMapping
    public void addStudent(@Valid @RequestBody Student student){
        studentService.addStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

}
