package com.deema.ems.timetable;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimetableService {

    private final TimetableRepository timetableRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TimetableService(TimetableRepository timetableRepository, ModelMapper modelMapper) {
        this.timetableRepository = timetableRepository;
        this.modelMapper = modelMapper;
    }

    public List<TimetableDTO> getTimetableForWeek(int weekNumber, String classroom) {
        List<Timetable> timetables = timetableRepository.findByWeekAndClassRoom(weekNumber, classroom);
        return timetables.stream()
                .map(timetable -> modelMapper.map(timetable, TimetableDTO.class))
                .collect(Collectors.toList());
    }

    public List<Timetable> getTimetableForDay(int weekNumber, Day day) {
        return timetableRepository.findByWeekAndDay(weekNumber, day);
    }

    @Transactional
    public Timetable createTimetable(Timetable timetable) throws Exception {
        // Check if a record already exists with the same week, day, and teacher
        boolean exists = timetableRepository.existsByWeekAndDayAndTimeSlotAndClassRoom(
                timetable.getWeek(),
                timetable.getDay(),
                timetable.getTimeSlot(),
                timetable.getClassRoom());

        if (exists) {
            throw new Exception(
                    "A timetable record for the same teacher already exists for the selected day and week.");
        }

        // If no conflicts, save the timetable
        return timetableRepository.save(timetable);
    }


}
