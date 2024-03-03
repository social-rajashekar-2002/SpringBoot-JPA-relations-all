package com.relations.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relations.demo.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher,Long>{
    
}
