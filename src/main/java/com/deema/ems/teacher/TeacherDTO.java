package com.deema.ems.teacher;


import com.deema.ems.subject.Subject;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TeacherDTO {
    private Long id;
    private String username;
    private String subjectSpecialization;
    private List<Subject> subjects;
}

