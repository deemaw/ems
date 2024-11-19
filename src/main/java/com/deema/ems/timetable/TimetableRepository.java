package com.deema.ems.timetable;

import com.deema.ems.teacher.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimetableRepository extends JpaRepository<Timetable, Long> {
    ;

    List<Timetable> findByWeekAndClassRoom(int week, String classRoom); // Get all timetables for a specific week

    boolean existsByWeekAndDayAndTimeSlotAndClassRoom(int week, Day day, TimeSlot timeSlot, String classroom);

    List<Timetable> findByWeekAndDay(int week, Day day); // Get all timetables for a specific day in a specific week
}

