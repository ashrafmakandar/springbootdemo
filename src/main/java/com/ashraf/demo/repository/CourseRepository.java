package com.ashraf.demo.repository;

import com.ashraf.demo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository  extends JpaRepository<Course, Long> {


}
