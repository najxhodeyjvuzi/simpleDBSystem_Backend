package cn.simpleSystem.springboot_demo.DAO;

import cn.simpleSystem.springboot_demo.entity.*;
import cn.simpleSystem.springboot_demo.entity.Course;

import java.util.List;


public interface CoursesDao {
    List<Course> list();

    List<Course> list(boolean basic);

    int add(Course course);

    int delete(long course);

}
