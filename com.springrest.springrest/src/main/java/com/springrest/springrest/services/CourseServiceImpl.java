package com.springrest.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.Repository.CourseRepository;
import com.springrest.springrest.entities.Course;
import com.springrest.springrest.exception.CourseNotFoundException;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	Course course = new Course();

	@Override
	public List<Course> courseList() {

		return courseRepository.findAll();
	}

	@Override
	public void deleteById(String id) {

		this.courseRepository.deleteById(id);

	}

	@Override
	public Course save(Course course) {

		return this.courseRepository.save(course);
	}

	@Override
	public List<Course> getAllCourse() {

		return courseRepository.findAll();
	}

	@Override
	public Course fetchCourseById(String id) throws CourseNotFoundException{
		if(courseRepository.existsById(course.getId())) { 
			throw new CourseNotFoundException(id + "Course Not Found");
			
		}
		else {
			return courseRepository.findById(id).get();
		
			
		}

		
	}
}
