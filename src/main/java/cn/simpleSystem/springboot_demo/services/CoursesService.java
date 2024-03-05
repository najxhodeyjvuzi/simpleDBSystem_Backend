package cn.simpleSystem.springboot_demo.services;

import cn.simpleSystem.springboot_demo.entity.*;
import cn.simpleSystem.springboot_demo.entity.Course;

import java.util.List;

public interface CoursesService {
    List<Course> list(boolean basic);

    int add(Course course);

    int delete(long course);


}