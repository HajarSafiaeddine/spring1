package com.example.demo.services;

import com.example.demo.entities.Student;
import com.example.demo.entities.StudentRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
    public String addStudent(Student student) {
          studentRepository.save(student);
          return "student added successfully";
   }
   public Student findStudent(String name){
        return studentRepository.findByName(name);
   }
   public String deleteOne(Long id) {
        studentRepository.deleteById(id);
        return "Student deleted successfully!";
    }
    public String updateOne(Student newStudent,Long id){
        Student currentStudent = studentRepository.findById(id).get();
        currentStudent.setId(newStudent.getId());
        currentStudent.setName(newStudent.getName());
        currentStudent.setEmail(newStudent.getEmail());
        currentStudent.setDate(newStudent.getDate());
        studentRepository.save(currentStudent);
        return "Student updated successfully!";
    }
}
