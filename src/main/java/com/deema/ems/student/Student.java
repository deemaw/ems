package com.deema.ems.student;

import com.deema.ems.subject.Subject;
import com.deema.ems.user.User;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@JsonTypeName("student")
public class Student extends User {
    private String studentId;
    private int grade;

    @ManyToMany
    @JoinTable(
            name = "student_subject",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subjects;

    public Student() {
        super();
    }


}

