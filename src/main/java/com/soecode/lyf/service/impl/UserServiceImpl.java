package com.soecode.lyf.service.impl;

import com.soecode.lyf.annotation.Router;
import com.soecode.lyf.dao.UserDao;
import com.soecode.lyf.entity.User;
import com.soecode.lyf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Function: TODO
 *
 * @author Viki
 * @date 2018/9/6 16:26
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;


    @Override
    @Router
    public int addUser(User user) {
        return userDao.addUser(user);
    }
}
