package com.relations.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relations.demo.entity.CourseMaterial;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterial,Long>{
    
}
