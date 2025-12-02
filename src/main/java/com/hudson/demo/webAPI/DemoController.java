package com.hudson.demo.webAPI;

import com.hudson.demo.JPA.entites.Student;
import com.hudson.demo.JPA.entites.Course;
import com.hudson.demo.JPA.services.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return demoService.findAllStudents();
    }

    @GetMapping("/students/search")
    public List<Student> searchStudents(@RequestParam String name) {
        return demoService.searchStudentByName(name);
    }

    @PostMapping("/students")
    public Student createOrUpdateStudent(@RequestParam String name, @RequestBody Student student) {
        return demoService.saveOrUpdateStudent(name, student);
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return demoService.updateStudent(id, student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        demoService.deleteStudent(id);
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return demoService.findAllCourses();
    }

    @GetMapping("/courses/search")
    public List<Course> searchCourses(@RequestParam String name) {
        return demoService.searchCourseByName(name);
    }

    @PostMapping("/courses")
    public Course createOrUpdateCourse(@RequestParam String name, @RequestBody Course course) {
        return demoService.saveOrUpdateCourse(name, course);
    }

    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable Long id) {
        demoService.deleteCourse(id);
    }
}

