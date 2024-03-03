package com.relations.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {

    @Id
    @SequenceGenerator(name = "cousre_seq",sequenceName = "couse_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_seq")
    private Long courseId;
    private int cerdit;
    private String title;


    // for bidirectional mapping
    @OneToOne(mappedBy = "course")
    private CourseMaterial courseMaterial;


    @ManyToOne(
        cascade = CascadeType.ALL
    )
    @JoinColumn(
        name="join_course_with_teacher",
        referencedColumnName="teacherId"
    )
    private Teacher teacher;


    // cerate a new table that has two clms
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="student_course_mapping",
                joinColumns = @JoinColumn(name="course_id",referencedColumnName = "courseId"),
                inverseJoinColumns = @JoinColumn(name="student_id",referencedColumnName = "id") )
    private List<Student>students;



}
