package cn.simpleSystem.springboot_demo.services;

import cn.simpleSystem.springboot_demo.DAO.TeacherDao;
import cn.simpleSystem.springboot_demo.entity.*;
import cn.simpleSystem.springboot_demo.entity.Teachers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherDao teacherDao;

    @Override
    public List<Teachers> list(boolean basic) {
        return teacherDao.list(basic);
    }

    @Override
    public int add(Teachers teacher) {
        return teacherDao.add(teacher);
    }

    @Override
    public int update(Teachers teacher) {
        return teacherDao.update(teacher);
    }

    @Override
    public int delete(long teacher) {
        return teacherDao.delete(teacher);
    }

}