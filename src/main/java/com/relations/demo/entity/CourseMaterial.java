package com.relations.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "course")
public class CourseMaterial {
    @Id
    @SequenceGenerator(name = "cousreMaterial_seq",sequenceName = "cousreMaterial_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cousreMaterial_seq")
    private Long courseMAterialId;
    private String url;



    // cascade helps to persist object without saving see testing 
    // fetching lazy prints only coursematerial not course data also add tostring exclude
    // here course clm is optional=false it means course object must be created
    // course can be created without course material
    @OneToOne(cascade = CascadeType.ALL,
                fetch = FetchType.LAZY,
                optional = false)
    @JoinColumn(name="join_course_and_material",referencedColumnName = "courseId")
    private Course course;



}
