package com.relations.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.relations.demo.entity.Course;
import com.relations.demo.entity.CourseMaterial;

@SpringBootTest
public class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){

        Course course=Course.builder()
                        .cerdit(6)
                        .title("physics")
                        .build();
                        
        CourseMaterial object =
                            CourseMaterial.builder()
                            .url("wwwGJ.com")
                            .course(course)
                            .build();



        courseMaterialRepository.save(object);

    }


    @Test
    public void printAllCourse(){
        List<CourseMaterial> courseMaterials=courseMaterialRepository.findAll();
        System.out.println(courseMaterials);

    }
}
