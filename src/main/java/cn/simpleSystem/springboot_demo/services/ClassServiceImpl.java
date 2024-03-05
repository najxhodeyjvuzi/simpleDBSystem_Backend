package cn.simpleSystem.springboot_demo.services;

import cn.simpleSystem.springboot_demo.DAO.ClassDao;
import cn.simpleSystem.springboot_demo.entity.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassServiceImpl implements ClassService{
    @Autowired
    ClassDao classDao;
    @Override
    public List<Class> list() {
        return classDao.list();
    }
}
