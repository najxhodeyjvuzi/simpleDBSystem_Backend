package cn.simpleSystem.springboot_demo.services;

import cn.simpleSystem.springboot_demo.DAO.CoursesDao;
import cn.simpleSystem.springboot_demo.entity.*;
import cn.simpleSystem.springboot_demo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesServiceImpl implements CoursesService {
    @Autowired
    CoursesDao coursesDao;

    @Override
    public List<Course> list(boolean basic) {
        return coursesDao.list(basic);
    }

    @Override
    public int add(Course course) {
        return coursesDao.add(course);
    }

    @Override
    public int delete(long course) {
        return coursesDao.delete(course);
    }

}