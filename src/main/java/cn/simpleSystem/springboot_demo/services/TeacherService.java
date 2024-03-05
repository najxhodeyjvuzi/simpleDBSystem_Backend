package cn.simpleSystem.springboot_demo.services;

import cn.simpleSystem.springboot_demo.entity.*;
import cn.simpleSystem.springboot_demo.entity.Teachers;

import java.util.List;

public interface TeacherService {
    List<Teachers> list(boolean basic);

    int add(Teachers teachers);

    int update(Teachers teachers);

    int delete(long teachers);


}