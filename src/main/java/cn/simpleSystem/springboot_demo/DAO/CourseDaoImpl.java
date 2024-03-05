package cn.simpleSystem.springboot_demo.DAO;

import cn.simpleSystem.springboot_demo.entity.Course;
import cn.simpleSystem.springboot_demo.entity.SelectForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDaoImpl implements CourseDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Course> list() {
        String sql = "select * from course";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Course.class));
    }

    @Override
    public int update(SelectForm selectForm) {
        String sql = "UPDATE select_course SET usual_grade=?, final_grade=?, tid = ? WHERE sid=? AND cid = ?";
        return jdbcTemplate.update(sql, selectForm.getUsual_grade(), selectForm.getFinal_grade(),selectForm.getTid(),selectForm.getSid(), selectForm.getCid());
    }
}
