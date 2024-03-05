package cn.simpleSystem.springboot_demo.DAO;

import cn.simpleSystem.springboot_demo.entity.User;

public interface UserDao {
    boolean verify(User user);

}
