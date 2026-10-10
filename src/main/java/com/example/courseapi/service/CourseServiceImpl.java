package com.example.courseapi.service;

import com.example.courseapi.model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CourseServiceImpl implements CourseService {

    private final List<Course> courses = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(0);

    @Override
    public Course addCourse(Course course) {
        course.setId(counter.incrementAndGet());
        courses.add(course);
        return course;
    }

    @Override
    public List<Course> getAllCourses() {
        return new ArrayList<>(courses);
    }

    @Override
    public Course getCourseById(Long id) {
        return courses.stream()
                .filter(course -> course.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Course updateCourse(Long id, Course updatedCourse) {
        Course existingCourse = getCourseById(id);

        if (existingCourse == null) {
            return null;
        }

        existingCourse.setName(updatedCourse.getName());
        existingCourse.setDuration(updatedCourse.getDuration());

        return existingCourse;
    }

    @Override
    public boolean deleteCourse(Long id) {
        return courses.removeIf(
                course -> course.getId().equals(id)
        );
    }
}