package com.deema.ems.student;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {
    private Long id;
    private String username;
    private String email;
    private String studentId;
    private String grade;
}