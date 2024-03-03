package com.relations.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.relations.demo.entity.Student;

import jakarta.transaction.Transactional;

public interface StudentRepo extends JpaRepository<Student,Long>{
    public List<Student> findByFirstName(String str);
    public List<Student> findByFirstNameContaining(String str);
    public List<Student> findByGuardianName(String str);
    public Student findByFirstNameAndLastName(String firstName,String lastName);


    @Modifying
    @Transactional
    @Query(
        value="update student set first_name=?1 where email_address=?2",
        nativeQuery = true
    )
    void updateStudentNameByEmail(String firstName,String email);



}
