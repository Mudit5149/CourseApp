package com.springrest.springrest;


import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.springrest.springrest.Repository.CourseRepository;
import com.springrest.springrest.entities.Course;

import com.springrest.springrest.services.CourseServiceImpl;

@SpringBootTest
class SpringBootTutorialApplicationTests {
	@Mock
	CourseRepository courseRepository;
	@InjectMocks
	CourseServiceImpl courseServiceImpl;
	public List<Course> coupons;
	private Object CourseId;

	@Test

	void test_addCourse() {
		Course course = new Course("123", "React", "This is the react  course");
		Mockito.when((Course) this.courseRepository.save(course)).thenReturn(course);
		Assertions.assertEquals(course, this.courseServiceImpl.save(course));
	}




	

	@Test
	@Order(4)
	void test_deleteCourse() {
		String id = "123";
		this.courseServiceImpl.deleteById(id);
		((CourseRepository) Mockito.verify(this.courseRepository, Mockito.times(1))).deleteById(id);
	}

	
	}
