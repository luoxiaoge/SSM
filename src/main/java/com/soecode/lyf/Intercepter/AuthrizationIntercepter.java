package com.soecode.lyf.Intercepter;

import com.soecode.lyf.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * Function: TODO
 *
 * @author Viki
 * @date 2018/8/15 17:49
 */
public class AuthrizationIntercepter implements HandlerInterceptor {

    // 不拦截 "/loginForm" 和 "/login" 请求
    private static  final String[] IGNORE_URI = {"/loginForm","/login"};


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("AuthorizationIntercepter  preHandler -->");
        // flag
        boolean flag =false;
        String servletPath = request.getServletPath();
        // 判断请求是否正确
        for (String s : IGNORE_URI){
            if (servletPath.contains(s)){
                flag = true;
                break;
            }
        }
        //拦截请求
        if (!flag){
            // 获取 session 中的用户  BUG >>>> name 加了一个逗号导致取不到User
            User user = (User)request.getSession().getAttribute("user");
            System.out.println(  request.getSession().getAttributeNames());
            Enumeration<String> a = request.getSession().getAttributeNames();
            while (a.hasMoreElements()){
                user = (User)  request.getSession().getAttribute(a.nextElement());
            }
            // 判断用户是否已经登陆
            if (user == null){
                // 如果用户没有登陆，则提示信息 转到登陆页面
                System.out.println("拦截请求  >>>>>>>");
                request.setAttribute("message","请先登录访问网站:");
                request.getRequestDispatcher("/loginForm").forward(request,response);
            }else {
                // 如果用户已经登陆 ，则验证通过，f放行
                System.out.println("放行请求  >>>>>>>>>>>");
                flag = true;
            }
        }
        return  flag;
    }



    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("AuthorizationIntercepter postHandle -->");
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("AuthorizationIntercepter afterCompletion -->");
    }
}
