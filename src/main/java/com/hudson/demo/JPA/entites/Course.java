package com.hudson.demo.JPA.entites;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // similar to SERIAL
    private Long id;

    private String name;


    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;

    public Course() {
    }

    public Course(String name, String code) {
        this.name = name;
    }



    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}

