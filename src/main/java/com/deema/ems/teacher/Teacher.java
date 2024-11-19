package com.deema.ems.teacher;

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
@JsonTypeName("teacher")
public class Teacher extends User {
    private String name;
    private String subjectSpecialization;

    @ManyToMany
    @JoinTable(
            name = "teacher_subject",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )

    private List<Subject> subjects;

    public Teacher() {
        super();
    }

}

