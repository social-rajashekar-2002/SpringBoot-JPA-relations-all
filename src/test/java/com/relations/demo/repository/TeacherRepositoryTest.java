package com.relations.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){

        // Course course1=Course.builder()
        //                 .cerdit(7)
        //                 .title("chemistry")
        //                 .build();

        // Course course2=Course.builder()
        //                 .cerdit(7)
        //                 .title("biology")
        //                 .build();

        // Teacher teacher=Teacher.builder()
        //                 .firstName("suma")
        //                 .lastName("kavya")
        //                 .courses(List.of(course1,course2))
        //                 .build();

        // teacherRepository.save(teacher);
    }
}
