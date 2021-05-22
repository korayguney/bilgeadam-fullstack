package com.bilgeadam.bilgeadamfullstack.contoller;

import com.bilgeadam.bilgeadamfullstack.model.Gender;
import com.bilgeadam.bilgeadamfullstack.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    @GetMapping
    public List<Student> getAllStudents(){
        List<Student> studentList = Arrays.asList(
                new Student(1L,"Koray Guney","koray@gmail.com", Gender.MALE),
                new Student(2L,"Furkan Okcu","furkan@gmail.com", Gender.MALE),
                new Student(3L,"Kaan Keskin","kaan@gmail.com", Gender.MALE),
                new Student(4L,"Oguzhan Olgun","oguzhan@gmail.com", Gender.MALE),
                new Student(5L,"Veli Bostan","veli@gmail.com", Gender.MALE),
                new Student(6L,"Sefa Yıldırım","sefa@gmail.com", Gender.MALE)
        );
        return studentList;
    }


}
