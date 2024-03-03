package com.relations.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="student",
        uniqueConstraints = @UniqueConstraint(columnNames = "email_address"))
public class Student {

    @Id
    @SequenceGenerator(name="student_seq",sequenceName = "student_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_seq")
    private Long id;
    private String firstName;
    private String lastName;

    @Column(name="email_address",nullable = false)
    private String email;

    @Embedded
    private Guardian guardian;
    //guardian is made seperate not to make it has entity
}
