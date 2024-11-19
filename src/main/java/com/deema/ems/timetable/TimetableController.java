package com.deema.ems.timetable;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timetables")
@CrossOrigin(origins = "*")
public class TimetableController {

    @Autowired
    private TimetableService timetableService;

    // Create a new timetable entry
    @PostMapping
    public ResponseEntity<Timetable> createTimetable(@RequestBody Timetable timetable) throws Exception {
        Timetable createdTimetable = timetableService.createTimetable(timetable);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTimetable);
    }

    @GetMapping
    public ResponseEntity<List<TimetableDTO>> getTimetables(@PathParam("weekNumber") int weekNumber, @PathParam("classroom") String classroom) {
        List<TimetableDTO> timetables = timetableService.getTimetableForWeek(weekNumber, classroom);
        return ResponseEntity.ok(timetables);
    }

}
