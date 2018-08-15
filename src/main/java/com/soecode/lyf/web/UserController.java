package com.soecode.lyf.web;

import com.soecode.lyf.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Function: TODO
 *
 * @author Viki
 * @date 2018/8/9 11:50
 * spring 自带国际化
 *
 */
@Controller
public class UserController {

    @RequestMapping(value = "/{formName}")
     public String loginForm(@PathVariable String formName,
            Model model){
        User user = new User();
        model.addAttribute("user",user);
        // 动态跳转页面
        return formName;
     }

     @RequestMapping(value = "/login",method = RequestMethod.POST)
     public String login(@ModelAttribute @Validated User user, Model model, HttpServletRequest request){
         // 如果登陆名是fkit, 密码是123456，则验证通过
         if (user.getLoginname() != null && "fkit".equals(user.getLoginname()) && user.getPassword() != null &&
                 "123456".equals(user.getPassword())){
              //从后台代码获取国际化信息userName
             RequestContext requestContext = new RequestContext(request);
             String userName = requestContext.getMessage("username");
             user.setUsername(userName);
             model.addAttribute("user",user);
             return "success";
         }
         return "error";
     }

}
