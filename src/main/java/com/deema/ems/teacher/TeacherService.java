package com.deema.ems.teacher;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<TeacherDTO> getAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private TeacherDTO convertToDto(Teacher teacher) {
        return modelMapper.map(teacher, TeacherDTO.class);
    }

    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    @Transactional
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}

