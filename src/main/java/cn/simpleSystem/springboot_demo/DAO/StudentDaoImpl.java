package cn.simpleSystem.springboot_demo.DAO;

import cn.simpleSystem.springboot_demo.entity.*;
import cn.simpleSystem.springboot_demo.entity.*;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> list() {
        String sql = "SELECT * FROM student";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
    }

    @Override
    public List<Student> list(boolean basic) {
        if (basic) {
            String sql = "SELECT sid,name FROM student";
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        }
        return list();
    }

    @Override
    public int add(StudentForm student) {
        String sql = "INSERT INTO student VALUES(?,?,?,?,?)";
        return jdbcTemplate.update(sql, student.getSid(), student.getName(), student.getGender(), student.getGrade(), student.getTelephone());
    }

    @Override
    public int update(Student student) {
        String sql = "UPDATE student SET name=?, gender=?, grade=?, telephone=?  WHERE sid=?";
        return jdbcTemplate.update(sql, student.getName(), student.getGender(),student.getGrade(),student.getTelephone(),student.getSid());
    }

    @Override
    public int delete(long student) {
        String sql = "DELETE FROM student WHERE sid=?";
        return jdbcTemplate.update(sql, student);
    }

    @Override
    public List<StudentSelection> selections() {
        String sql = "select student.sid,name,JSON_ARRAYAGG(JSON_OBJECT('cid',course.cid,'cname',cname,'tid',teacher.tid,'tname',tname,'usual_grade',usual_grade,'final_grade',final_grade)) as selections from student,select_course,course,teacher where student.sid=select_course.sid and select_course.cid=course.cid and select_course.tid=teacher.tid group by student.sid,name;";
        RowMapper<StudentSelection> rowMapper = (rs, rowNum) -> {
            StudentSelection ss = new StudentSelection();
            ss.setSid(rs.getLong("sid"));
            ss.setName(rs.getString("name"));
            List<CourseSelection> cs = JSON.parseObject(rs.getString("selections"), new TypeReference<>() {
            });
            ss.setSelections(cs);
            return ss;
        };
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public int putSelection(SelectionForm selectionForm) {
        String sql = "insert into select_course values(?,?,?,?,?)";
        return jdbcTemplate.update(sql, selectionForm.getSid(), selectionForm.getCid(),selectionForm.getTid(),selectionForm.getUsual_grade(),selectionForm.getFinal_grade());
    }

    @Override
    public int delSelection(SelectionForm selectionForm) {
        String sql="delete from select_course where sid=? and cid=?";
        return  jdbcTemplate.update(sql, selectionForm.getSid(), selectionForm.getCid());
    }
}
