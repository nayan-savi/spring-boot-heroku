package com.course.system.courseapplicationsystem.service;

import com.course.system.courseapplicationsystem.model.Course;
import com.course.system.courseapplicationsystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class CourseServiceImpl {

    @Autowired
    private CourseRepository courseRepository;

    public boolean save(Course course) {
        course.setId(UUID.randomUUID());
        course.setDays(getNumberOfDays(course));
        Course save = courseRepository.save(course);
        return save.getId() != null;
    }

    private long getNumberOfDays(Course course) {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = sd.parse(course.getStartDate());
            Date endDate = sd.parse(course.getEndDate());
            long diff = endDate.getTime() - startDate.getTime();
            return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }


    public void delete(UUID uuid) {
        courseRepository.deleteById(uuid);
    }

    public Course getCourseById(UUID uuid) {
        return courseRepository.findById(uuid).get();
    }

    public Course updateById(Course course) {
        course.setDays(getNumberOfDays(course));
        return courseRepository.save(course);
    }
}
