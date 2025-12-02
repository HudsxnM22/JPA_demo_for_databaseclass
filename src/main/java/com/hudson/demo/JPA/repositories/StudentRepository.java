package com.hudson.demo.JPA.repositories;

import com.hudson.demo.JPA.entites.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByEmail(String email); // Optional means it may or may not be present

    List<Student> findByName(String name); // could be an empty list

    List<Student> findByNameContaining(String name);
}

