package com.deema.ems.subject;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SubjectDTO {
    private Long id;
    private String name;
    private String code;
    private List<Subject> subjects;


}