package com.bilgeadam.bilgeadamfullstack.service;

import com.bilgeadam.bilgeadamfullstack.exception.BadRequestException;
import com.bilgeadam.bilgeadamfullstack.model.Gender;
import com.bilgeadam.bilgeadamfullstack.model.Student;
import com.bilgeadam.bilgeadamfullstack.repository.StudentRepository;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    StudentRepository studentRepository;
    StudentService studentService;

    @BeforeEach
    void setUp(){
        studentService = new StudentService(studentRepository);
    }

    @Test
    void getAllStudents() {
        //given
        Mockito.when(studentRepository.findAll()).thenReturn(Collections.singletonList(
                new Student("Koray", "koray@gmail.com", Gender.MALE)
        ));

        //when
        List<Student> studentList = studentService.getAllStudents();
        //then
        Mockito.verify(studentRepository).findAll();
        assertEquals(studentList.get(0).getGender(), Gender.MALE);
    }

    @Test
    void addStudent() {
        // given
        Student student = new Student("Koray", "koray@gmail.com", Gender.MALE);

        // when
        studentService.addStudent(student);

        // then
        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);
        Mockito.verify(studentRepository).save(studentArgumentCaptor.capture());
        Student capturedStudent =  studentArgumentCaptor.getValue();

        assertEquals(capturedStudent, student);
    }

    @Test
    void willThrowWhenEmailIsTaken() {
        // given
        Student student = new Student("Koray", "koray@gmail.com", Gender.MALE);
        Mockito.when(studentRepository.selectExistsEmail("koray@gmail.com")).thenReturn(true);

        // when

        // then
        Assertions.assertThatThrownBy(() -> studentService.addStudent(student))
                .isInstanceOf(BadRequestException.class)
                .hasMessageContaining("Email " + student.getEmail() +" taken");

        Mockito.verify(studentRepository, Mockito.never()).save(student);
    }

    @Test
    @Disabled
    void deleteStudent() {
    }
}