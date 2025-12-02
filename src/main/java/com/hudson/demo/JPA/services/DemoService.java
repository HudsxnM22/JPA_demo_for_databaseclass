package com.hudson.demo.JPA.services;

import com.hudson.demo.JPA.entites.Student;
import com.hudson.demo.JPA.entites.Course;
import com.hudson.demo.JPA.repositories.StudentRepository;
import com.hudson.demo.JPA.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    // ---------------------------
    // FIND METHODS
    // ---------------------------

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    public List<Student> searchStudentByName(String name) {
        return studentRepository.findByNameContaining(name);
    }

    public List<Course> searchCourseByName(String name) {
        return courseRepository.findByNameContaining(name);
    }

    // ---------------------------
    // SAVE OR UPDATE STUDENT AND COURSE
    // ---------------------------

    public Student saveOrUpdateStudent(String name, Student student) {

        List<Student> matches = studentRepository.findByName(name);

        if (!matches.isEmpty()) {
            // Get the first student found
            Student existing = matches.get(0);

            // Update fields
            existing.setName(student.getName());
            existing.setEmail(student.getEmail());

            // Save updated student
            return studentRepository.save(existing);
        }

        // No match, save new student
        return studentRepository.save(student);
    }

    public Course saveOrUpdateCourse(String name, Course course) {

        List<Course> matches = courseRepository.findByName(name);

        if (!matches.isEmpty()) {
            Course existing = matches.get(0);

            // Update fields
            existing.setName(course.getName());
            existing.setStudent(course.getStudent());

            return courseRepository.save(existing);
        }

        return courseRepository.save(course);
    }

    // ---------------------------
    // DELETE
    // ---------------------------

    public Student updateStudent(Long id, Student student) {
        Student existing = studentRepository.findById(id).orElseThrow();
        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        return studentRepository.save(existing);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
