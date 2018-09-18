package com.soecode.lyf.dao;

import com.soecode.lyf.entity.User;
import org.springframework.stereotype.Component;

/**
 * Function: TODO
 *
 * @author Viki
 * @date 2018/9/5 15:29
 */
@Component
public interface UserDao {

    int addUser(User user);
}
