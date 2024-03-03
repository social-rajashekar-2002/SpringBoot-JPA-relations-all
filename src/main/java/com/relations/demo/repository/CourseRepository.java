package com.relations.demo.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.relations.demo.entity.Course;



public interface CourseRepository extends JpaRepository<Course,Long>{

    Page<Course> findByTitleContaining(String title,Pageable pageable);
    
}