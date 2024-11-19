package com.deema.ems.timetable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TimetableDTO {
    private String day;
    private String timeSlot;
    private String subjectName;
    private String teacherName;
    private String classroom;
    private String week;
}

