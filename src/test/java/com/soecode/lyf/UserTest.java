package com.soecode.lyf;

import com.soecode.lyf.entity.User;
import com.soecode.lyf.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Function: TODO
 *
 * @author Viki
 * @date 2018/9/7 10:08
 */
public class UserTest extends BaseTest {

    @Autowired
    UserService userService;

    @Test

    public void addUser(){
        User user = new  User();
        user.setUsername("luoc");
        user.setAge(23);
        user.setEmail("1012293013@qq.com");
        user.setPhone("18773871429");
        userService.addUser(user);
    }

}
