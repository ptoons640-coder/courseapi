package com.example.courseapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.courseapi.model.Course;
import com.example.courseapi.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public Course updateCourse(Long id, Course updatedCourse) {

        Course existingCourse = courseRepository.findById(id).orElse(null);

        if (existingCourse == null) {
            return null;
        }

        existingCourse.setName(updatedCourse.getName());
        existingCourse.setDuration(updatedCourse.getDuration());

        return courseRepository.save(existingCourse);
    }

    @Override
    public boolean deleteCourse(Long id) {

        if (!courseRepository.existsById(id)) {
            return false;
        }

        courseRepository.deleteById(id);
        return true;
    }
}