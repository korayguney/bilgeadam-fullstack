package com.bilgeadam.bilgeadamfullstack.repository;

import com.bilgeadam.bilgeadamfullstack.model.Gender;
import com.bilgeadam.bilgeadamfullstack.model.Student;
import org.aspectj.lang.annotation.After;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository underTest;

    @AfterEach
    void tearDown(){
        underTest.deleteAll();
    }

    @Test
    void itShouldCheckWhenStudentEmailExists() {
        // given
        Student student = new Student(
                "Koray",
                "koray@gmail.com",
                Gender.MALE
        );
        underTest.save(student);

        // when
        boolean excepted = underTest.selectExistsEmail(student.getEmail());

        // then
        assertTrue(excepted);
        Assertions.assertThat(excepted).isTrue();
    }

    @Test
    void itShouldCheckWhenStudentEmailDoesNotExists() {
        // given
        String email = "aaa@gmail.com";

        // when
        boolean excepted = underTest.selectExistsEmail(email);

        // then
        assertFalse(excepted);
    }
}