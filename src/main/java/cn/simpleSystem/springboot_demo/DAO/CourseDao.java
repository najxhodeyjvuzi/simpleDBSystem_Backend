package cn.simpleSystem.springboot_demo.DAO;

import cn.simpleSystem.springboot_demo.entity.Course;
import cn.simpleSystem.springboot_demo.entity.SelectForm;

import java.util.List;

public interface CourseDao {
    List<Course> list();
    int update(SelectForm selectForm);
}
