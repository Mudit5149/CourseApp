package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.exception.CourseNotFoundException;

public interface CourseService {

	List<Course> courseList();

	Course fetchCourseById(String id) throws CourseNotFoundException;

	void deleteById(String id);

	Course save(Course course);

	List<Course> getAllCourse();

}