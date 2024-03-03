package com.relations.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.relations.demo.entity.Course;
import com.relations.demo.entity.Student;
import com.relations.demo.entity.Teacher;


@SpringBootTest
public class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printAllCourses(){
        List<Course> course=courseRepository.findAll();
    }

    @Test
    public void saveCourseWithTeacherObject(){
        
        Teacher teacher=Teacher.builder()
                        .firstName("kite")
                        .lastName("fly")
                        .build();
                                        
        Course course=Course.builder()
                        .cerdit(7)
                        .courseMaterial(null)
                        .title("monkey")
                        .teacher(teacher)
                        .build();

        courseRepository.save(course);
    }


    @Test
    public void finAllPagination(){
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithThreeRecords = PageRequest.of(1, 2);
        List<Course>courses=courseRepository.findAll(firstPageWithThreeRecords).getContent();
        Long lengthElements =courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
        int lengthPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();

        System.out.println(firstPageWithThreeRecords);
        System.out.println("------------");
        System.out.println(secondPageWithThreeRecords);
        System.out.println("----------------");
        System.out.println(courses);
        System.out.println("--------");
        System.out.println(lengthPages);
        System.out.println("---------");
        System.out.println(lengthElements);
    }

    @Test
    public void findAllWithSorting(){
        Pageable sortRecords=PageRequest.of(1, 4, Sort.by("title"));

        Pageable sortDescRecords=PageRequest.of(1, 4, Sort.by("title").descending());

        Pageable sortTitleAndCreditsRecords=PageRequest.of(
              1,
              4,
              Sort.by("title")
              .descending()
              .and(Sort.by("cerdit"))
              );

        List<Course>courses=courseRepository.findAll(sortRecords).getContent();
        System.out.println(courses);

    }


    @Test
    public void printByContaining(){
        Pageable firstPageTenRecords=PageRequest.of(1, 10);

        List<Course> courses=courseRepository.findByTitleContaining("m", firstPageTenRecords).getContent();
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher=Teacher.builder()
                        .firstName("njam")
                        .lastName("kya")
                        .build();

        Student student1=Student.builder()
                        .firstName("student....")
                        .lastName("last")
                        .email("@gai..l.cm")
                        .build();

        Student student2=Student.builder()
                        .firstName("student")
                        .lastName("last")
                        .email("@jil.cm")
                        .build();

        List<Student>students=new ArrayList<>();
        students.add(student2);
        students.add(student1);

        Course course=Course.builder()
                        .teacher(teacher)
                        .cerdit(4)
                        .title("lion")
                        .students(students)
                        .build();

        // course.addStudent(student);

        courseRepository.save(course);
    }

}





