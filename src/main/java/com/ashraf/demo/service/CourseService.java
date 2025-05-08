package com.ashraf.demo.service;

import com.ashraf.demo.model.Course;
import com.ashraf.demo.model.User;
import com.ashraf.demo.repository.CourseRepository;
import com.ashraf.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private UserRepository userRepository;


    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
    public Course saveCourse(Course course) {
        User user = userRepository.findById(course.getUser().getId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        // Set the user to the course
        course.setUser(user);
        return courseRepository.save(course);  // Save course to the database
    }
}
