package com.bilgeadam.bilgeadamfullstack.service;

import com.bilgeadam.bilgeadamfullstack.exception.BadRequestException;
import com.bilgeadam.bilgeadamfullstack.exception.StudentNotFoundException;
import com.bilgeadam.bilgeadamfullstack.model.Student;
import com.bilgeadam.bilgeadamfullstack.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    public final StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        boolean isExists = studentRepository.selectExistsEmail(student.getEmail());
        if(isExists){
            throw new BadRequestException("Email " + student.getEmail() +" taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        if(!studentRepository.existsById(studentId)){
            throw new StudentNotFoundException("Student with id " + studentId + " does not exists");
        }
        studentRepository.deleteById(studentId);
    }
}
