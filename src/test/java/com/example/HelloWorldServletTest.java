package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldTest {

    HelloWorld helloWorld = new HelloWorld();

    @Test
    void testSayHelloWithName() {
        String result = helloWorld.sayHello("Alice");
        assertEquals("Hello, Alice!", result);
    }

    @Test
    void testSayHelloWithoutName() {
        String result = helloWorld.sayHello("");
        assertEquals("Hello, World!", result);
    }

    @Test
    void testSayHelloWithNull() {
        String result = helloWorld.sayHello(null);
        assertEquals("Hello, World!", result);
    }
}

