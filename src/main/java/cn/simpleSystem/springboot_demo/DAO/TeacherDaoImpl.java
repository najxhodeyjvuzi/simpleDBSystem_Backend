package cn.simpleSystem.springboot_demo.DAO;

import cn.simpleSystem.springboot_demo.entity.*;
import cn.simpleSystem.springboot_demo.entity.Teachers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherDaoImpl implements TeacherDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Teachers> list() {
        String sql = "SELECT * FROM teacher";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Teachers.class));
    }

    @Override
    public List<Teachers> list(boolean basic) {
        if (basic) {
            String sql = "SELECT tid,tname FROM teacher";
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Teachers.class));
        }
        return list();
    }

    @Override
    public int add(Teachers teacher) {
        String sql = "INSERT INTO teacher VALUES(?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, teacher.getTid(), teacher.getTname(), teacher.getGender(), teacher.getSalary(), teacher.getAge(), teacher.getTelephone());
    }

    @Override
    public int update(Teachers teacher) {
        String sql = "UPDATE teacher SET tname=?, gender=?, age=?, salary=?, telephone=?  WHERE tid=?";
        return jdbcTemplate.update(sql, teacher.getTname(), teacher.getGender(),teacher.getAge(),teacher.getSalary(),teacher.getTelephone(),teacher.getTid());
    }

    @Override
    public int delete(long teacher) {
        String sql = "DELETE FROM teacher WHERE tid=?";
        return jdbcTemplate.update(sql, teacher);
    }


}
