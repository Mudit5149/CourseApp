package com.springrest.springrest.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.Repository.CourseRepository;
import com.springrest.springrest.entities.Course;
import com.springrest.springrest.exception.CourseNotFoundException;
import com.springrest.springrest.services.CourseService;

@RestController
@RequestMapping("/course")
public class MyController {

	@Autowired
	private CourseService courseService;

	@Autowired
	CourseRepository courseRepository;

	private final Logger LOGGER = LoggerFactory.getLogger(MyController.class);

	@PostMapping("/addcourse")
	public ResponseEntity<String> course1(@RequestBody Course course) {
		courseRepository.save(course);
		return new ResponseEntity<String>("object is inserted", HttpStatus.OK);
	}

	@GetMapping("/courses")
	public List<Course> findAllCourseList() {
		LOGGER.info("Inside fetchCourseList of CourseController");
		return courseService.courseList();
	}

	@GetMapping("/get")
	public Course fetchCourseById(@RequestParam("id") String id) throws CourseNotFoundException {
		
		return this.courseService.fetchCourseById(id);
		
	}

	@DeleteMapping("/delete")
	public String deleteCourseById(@RequestParam("id") String id) {
		this.courseService.deleteById(id);
		return "Course deleted Successfully!!";
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateProduct(@RequestBody Course course) {
		Course updateEntity = this.courseService.save(course);
		return ResponseEntity.ok(updateEntity);
	}

}
