package com.deema.ems.timetable;

import com.deema.ems.teacher.Teacher;
import com.deema.ems.teacher.TeacherDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TimetableDTO {
    private String day;
    private String timeSlot;
    private String subjectName;
    private Teacher teacher;
    private String classroom;
    private String week;
}

