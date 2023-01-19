package com.springrest.springrest.Repository;





import org.springframework.data.mongodb.repository.MongoRepository;


import com.springrest.springrest.entities.Course;

public interface CourseRepository extends MongoRepository<Course, String> {
	
	
}
