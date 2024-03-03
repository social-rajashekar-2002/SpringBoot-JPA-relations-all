package com.relations.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.relations.demo.entity.Guardian;
import com.relations.demo.entity.Student;

@SpringBootTest
public class StudentRepoTest {

    @Autowired
    private StudentRepo repo;

    @Test
    public void saveStudent(){
        Guardian guradianObject=Guardian.builder()
                                .email("gu@gil.com")
                                .name("gyaed")
                                .build();

        Student object=Student.builder()
                        .email("r@gdi.com")
                        .firstName("raju")
                        .guardian(guradianObject)
                        .lastName("ganiger")
                        .build();
        repo.save(object);
        
    }

    @Test
    public void upadateFirstNameByEmailaddress(){
        repo.updateStudentNameByEmail("newNName", "r@gmail.com");
    }


    @Test
    public void deleteByIdTest(){
        repo.deleteById(1l);
    }
}
