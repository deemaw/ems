package com.deema.ems.subject;

import com.deema.ems.student.Student;
import com.deema.ems.teacher.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;
    @JsonIgnore
    @ManyToMany(mappedBy = "subjects")
    private List<Teacher> teacher;
    @JsonIgnore
    @ManyToMany(mappedBy = "subjects")
    private List<Student> students;


}
