package com.course.system.courseapplicationsystem.controller;

import com.course.system.courseapplicationsystem.model.Course;
import com.course.system.courseapplicationsystem.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    private CourseServiceImpl courseService;

    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody Course course) throws ParseException {
        boolean save = courseService.save(course);
        return ResponseEntity.ok(save);
    }

    @ResponseBody
    @RequestMapping(value = "/course/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Course getCourseById(@PathVariable("id") UUID uuid) {
        return courseService.getCourseById(uuid);
    }

    @ResponseBody
    @RequestMapping(value = "/course", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Course updateById(@RequestBody Course course) {
        return courseService.updateById(course);
    }


    @ResponseBody
    @RequestMapping(value = "/courses", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> findAll() {
        return courseService.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") UUID uuid) {
        courseService.delete(uuid);
    }

}
