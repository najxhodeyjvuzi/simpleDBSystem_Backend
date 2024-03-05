package cn.simpleSystem.springboot_demo.services;

import cn.simpleSystem.springboot_demo.DAO.StudentDao;
import cn.simpleSystem.springboot_demo.entity.*;
import cn.simpleSystem.springboot_demo.entity.SelectionForm;
import cn.simpleSystem.springboot_demo.entity.Student;
import cn.simpleSystem.springboot_demo.entity.StudentForm;
import cn.simpleSystem.springboot_demo.entity.StudentSelection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;

    @Override
    public List<Student> list(boolean basic) {
        return studentDao.list(basic);
    }

    @Override
    public int add(StudentForm student) {
        return studentDao.add(student);
    }

    @Override
    public int update(Student student) {
        return studentDao.update(student);
    }

    @Override
    public int delete(long student) {
        return studentDao.delete(student);
    }

    @Override
    public List<StudentSelection> selection() {
        return studentDao.selections();
    }

    @Override
    public int putSelection(SelectionForm selectionForm) {
        return studentDao.putSelection(selectionForm);
    }

    @Override
    public int delSelection(SelectionForm selectionForm) {
        return studentDao.delSelection(selectionForm);
    }
}