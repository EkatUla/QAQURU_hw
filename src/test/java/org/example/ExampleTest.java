package org.example;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Random;


public class ExampleTest {
    @Test
    void ExampleTest(){
        Assertions.assertTrue(new Random().nextInt() > 1);

    }
    @Test
    void ExampleTest1(){
        Assertions.assertTrue(new Random().nextInt() > 2);

    }
}