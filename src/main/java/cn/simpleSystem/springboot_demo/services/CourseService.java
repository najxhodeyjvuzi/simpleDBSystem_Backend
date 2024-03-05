package cn.simpleSystem.springboot_demo.services;

import cn.simpleSystem.springboot_demo.entity.Course;
import cn.simpleSystem.springboot_demo.entity.SelectForm;

import java.util.List;

public interface CourseService {
    List<Course> list();
    int update(SelectForm select);
}
