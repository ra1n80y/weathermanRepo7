package com.WEATHER.rest;

import com.WEATHER.entity.Course;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController
{
    public CourseController()
    {
        System.out.println ("http://localhost:8080/info/1");
        System.out.println ("http://localhost:8080/all");
    }

    @GetMapping("info/{cid}")
    public ResponseEntity<Course> getCourseInfo(@PathVariable("cid")String ignoredCid)
    {
        Course course = new Course ("1","Python",4999.9,"Godfrey");

        Link link=WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn (CourseController.class)
                        .getAll ())
                .withRel ("getAll");

        System.out.println ("B4 link");
        course.add(link);
        System.out.println ("After link");

        return new ResponseEntity<> (course, HttpStatus.OK);
    }

    @GetMapping("all")
    public List<Course> getAll()
    {
        Course course1 = new Course ("1","Python",4999.9,"Godfrey");
        Course course2 = new Course ("2","C++",3999.9,"Benjamin");
        Course course3 = new Course ("3","PHP",2999.9,"Aaliyah");

        return new ArrayList<> (Arrays.asList (course1, course2, course3));
    }
}
