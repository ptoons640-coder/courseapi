package com.example.courseapi.controller;

import com.example.courseapi.model.Course;
import com.example.courseapi.service.CourseService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<Course> addCourse(
            @RequestBody Course course) {

        Course savedCourse = courseService.addCourse(course);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedCourse);
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(
            @PathVariable Long id) {

        Course course = courseService.getCourseById(id);

        if (course == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(
            @PathVariable Long id,
            @RequestBody Course course) {

        Course updatedCourse =
                courseService.updateCourse(id, course);

        if (updatedCourse == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedCourse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(
            @PathVariable Long id) {

        boolean deleted = courseService.deleteCourse(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}