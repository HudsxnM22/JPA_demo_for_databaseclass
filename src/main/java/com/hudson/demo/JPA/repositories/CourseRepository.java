package com.hudson.demo.JPA.repositories;

import com.hudson.demo.JPA.entites.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByName(String name);

    List<Course> findByNameContaining(String name);
}

