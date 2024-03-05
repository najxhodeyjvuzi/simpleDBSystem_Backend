package cn.simpleSystem.springboot_demo.services;

import cn.simpleSystem.springboot_demo.DAO.CourseDao;
import cn.simpleSystem.springboot_demo.entity.Course;
import cn.simpleSystem.springboot_demo.entity.SelectForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseDao courseDao;

    @Override
    public List<Course> list() {
        return courseDao.list();
    }

    public int update(SelectForm selectForm) {return courseDao.update(selectForm);}
}
