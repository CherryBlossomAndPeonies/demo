package com.example.demo.student;

import com.example.demo.student.interfaces.IStudentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService implements IStudentService {
    public List<Student> getStudents() {
        return List.of(new Student(
                1L,
                "Bali Naik",
                LocalDate.of(1996, 8, 25),
                26, "bali@gmail.com"));
    }
}
