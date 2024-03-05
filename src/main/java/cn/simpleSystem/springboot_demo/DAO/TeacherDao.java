package cn.simpleSystem.springboot_demo.DAO;

import cn.simpleSystem.springboot_demo.entity.*;
import cn.simpleSystem.springboot_demo.entity.Teachers;

import java.util.List;


public interface TeacherDao {
    List<Teachers> list();

    List<Teachers> list(boolean basic);

    int add(Teachers teacher);

    int update(Teachers teacher);

    int delete(long teacher);

}
