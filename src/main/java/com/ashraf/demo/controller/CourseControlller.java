package com.ashraf.demo.controller;


import com.ashraf.demo.model.Course;
import com.ashraf.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseControlller {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();  // Returns all courses with their associated users
    }
    @PostMapping("/addCourse")
    public Course createCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);  // Call service to save the course
    }
}