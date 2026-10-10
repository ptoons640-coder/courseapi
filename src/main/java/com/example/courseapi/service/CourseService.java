package com.example.courseapi.service;

import com.example.courseapi.model.Course;
import java.util.List;

public interface CourseService {

    Course addCourse(Course course);

    List<Course> getAllCourses();

    Course getCourseById(Long id);

    Course updateCourse(Long id, Course course);

    boolean deleteCourse(Long id);
}