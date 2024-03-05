package cn.simpleSystem.springboot_demo.DAO;

import cn.simpleSystem.springboot_demo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CoursesDaoImpl implements CoursesDao{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Course> list() {
        String sql = "SELECT * FROM course";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Course.class));
    }

    @Override
    public List<Course> list(boolean basic) {
        if (basic) {
            String sql = "SELECT cid,cname FROM course";
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Course.class));
        }
        return list();
    }

    @Override
    public int add(Course course) {
        String sql = "INSERT INTO course VALUES(?,?)";
        return jdbcTemplate.update(sql,course.getCid(),course.getCname());
    }

    @Override
    public int delete(long course) {
        String sql = "DELETE FROM course WHERE cid=?";
        return jdbcTemplate.update(sql, course);
    }
}
