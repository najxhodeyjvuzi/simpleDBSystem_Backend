package cn.simpleSystem.springboot_demo.services;

import cn.simpleSystem.springboot_demo.entity.*;
import cn.simpleSystem.springboot_demo.entity.SelectionForm;
import cn.simpleSystem.springboot_demo.entity.Student;
import cn.simpleSystem.springboot_demo.entity.StudentForm;
import cn.simpleSystem.springboot_demo.entity.StudentSelection;

import java.util.List;

public interface StudentService {
    List<Student> list(boolean basic);

    int add(StudentForm student);

    int update(Student student);

    int delete(long student);

    List<StudentSelection> selection();

    int putSelection(SelectionForm selectionForm);

    int delSelection(SelectionForm selectionForm);
}