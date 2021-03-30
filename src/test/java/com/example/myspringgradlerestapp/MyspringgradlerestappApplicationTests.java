package com.example.myspringgradlerestapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class MyspringgradlerestappApplicationTests {

        @Test
        void contextLoads() {
                assertTrue(true);
        }

        @Tag("fast")
        @Test
        void aSuperFastTest() {
                assertTrue(true);
        }

        @Tag("slow")
        @Test
        void aSuperSlowTest() {
                assertTrue(true);
        }
}
