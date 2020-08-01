package com.course.system.courseapplicationsystem.repository;

import com.course.system.courseapplicationsystem.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourseRepository extends CrudRepository<Course, UUID> {
}
