package com.habay.request;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "course-service"//Name of course-service application
, path = "/api/course"//Pre-path for course-service
//,url = "${course.service.url}"
,configuration = FeignConfiguration.class
)
public interface CourseServiceRequest
{
@PostMapping///api/course
Object saveCourse(@RequestBody Object requestBody);

@DeleteMapping("{courseId}")//api/course/{courseId}
void deleteCourse(@PathVariable("courseId") Long courseId);

@GetMapping//api/course
List<Object> getAllCourses();
}
