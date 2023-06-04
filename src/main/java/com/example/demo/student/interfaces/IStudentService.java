package com.example.demo.student.interfaces;

import com.example.demo.student.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IStudentService {
    List<Student> getStudents();
}
