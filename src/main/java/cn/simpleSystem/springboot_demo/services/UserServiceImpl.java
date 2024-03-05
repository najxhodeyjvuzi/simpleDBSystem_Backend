package cn.simpleSystem.springboot_demo.services;

import cn.simpleSystem.springboot_demo.DAO.UserDao;
import cn.simpleSystem.springboot_demo.entity.User;
import cn.simpleSystem.springboot_demo.utils.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public String login(User user) {
        if (userDao.verify(user)) {
            return JWT.generateToken(user.getAccount());
        } else {
            return null;
        }
    }

}
