package com.relations.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Teacher {
    @Id
    @SequenceGenerator(name="teacher_seq",sequenceName = "teacher_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="teacher_seq")
    private Long teacherId;
    private String firstName;
    private String lastName;

    // @OneToMany(cascade = CascadeType.ALL)
    // @JoinColumn(name="join_course_teacher",referencedColumnName = "teacherId")
    // private List<Course>courses;
}
