package com.example.demo.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {


    @Test
    void myTest(){
        int value = 100;
        Assertions.assertEquals(100,value);
    }

    @Test
    void testConstructor(){
        //Given
        Long id= 1L;
        String username ="Yassine";
        String password ="yassine";

        //When
        User user = new User(id,username,password);
        //Then
        Assertions.assertEquals(id,user.getId());
        Assertions.assertEquals(username, user.getUsername());
        Assertions.assertEquals(password,user.getPassword());

    }

}