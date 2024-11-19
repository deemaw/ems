package com.deema.ems.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
@CrossOrigin(origins = "*")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public ResponseEntity<List<SubjectDTO>> getAllSubjects() {
        List<SubjectDTO> subjectDTOs = subjectService.getAllSubjects();
        return ResponseEntity.ok(subjectDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable Long id) {
        Subject subject = subjectService.getSubjectById(id);
        if (subject != null) {
            return ResponseEntity.ok(subject); // HTTP 200 OK with subject data
        } else {
            return ResponseEntity.notFound().build(); // HTTP 404 Not Found if subject doesn't exist
        }
    }

    @PostMapping
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) {
        Subject createdSubject = subjectService.saveSubject(subject);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSubject); // HTTP 201 Created with new subject data
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable Long id) {
        if (subjectService.getSubjectById(id) != null) {
            subjectService.deleteSubject(id);
            return ResponseEntity.noContent().build(); // HTTP 204 No Content on successful deletion
        } else {
            return ResponseEntity.notFound().build(); // HTTP 404 Not Found if subject doesn't exist
        }
    }

}