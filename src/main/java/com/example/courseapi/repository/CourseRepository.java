package com.example.courseapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.courseapi.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}