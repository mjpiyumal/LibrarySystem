package com.mjcoding.service;

import com.mjcoding.entity.Students;
import com.mjcoding.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentsRepository studentsRepository;

    @Override
    public Students saveStudents(Students students) {
        return studentsRepository.save(students);
    }
}
