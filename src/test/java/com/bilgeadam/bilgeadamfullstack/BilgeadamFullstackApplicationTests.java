package com.bilgeadam.bilgeadamfullstack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class BilgeadamFullstackApplicationTests {

    Calculator calculatorUnderTest = new Calculator();

    @Test
    void itShouldAddTwoNumbers() {
        // BDD --> Behaviour Driven Development
        // given
        int numberOne = 10;
        int numberTwo = 50;

        // when
        int result = calculatorUnderTest.add(numberOne, numberTwo);

        // then
        int expected = 60;
        Assertions.assertEquals(result, expected);

    }

    class Calculator {
        int add (int a, int b){
            return a + b;
        }
    }
}
