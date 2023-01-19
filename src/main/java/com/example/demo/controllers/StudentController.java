package com.example.demo.controllers;
import com.example.demo.entities.Student;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/students")
public class StudentController {
  public final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService= studentService;
    }


    @GetMapping(value = "/getall")
    public List<Student> mystudents() {
           return studentService.getStudents();
    }

    @PostMapping(value = "/addnewone")
    public String addStudent(@RequestBody Student student){ return studentService.addStudent(student);}

    @GetMapping(value = "/name/{name}")
    @ResponseBody
    public Student findOne(@PathVariable String name){return studentService.findStudent(name);}

    @DeleteMapping(value = "/id/{id}")
    @ResponseBody
    public String deleteOne(@PathVariable Long id){return studentService.deleteOne(id);}

    @PutMapping(value = "/id/{id}")
    @ResponseBody
    public String updateOne(@RequestBody Student student,@PathVariable Long id){return studentService.updateOne(student,id);}



}
