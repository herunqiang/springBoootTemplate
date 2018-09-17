package com.example.template.controller;


import com.example.template.common.entity.SysUser;
import com.example.template.common.util.RequestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping(value = "/auth")
public class LoginController {

    @RequestMapping(value = "/login")
    public String submitLogin(String username, String password, HttpServletRequest request) {

        System.out.println("ss");
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            SysUser user = (SysUser) subject.getPrincipal();
        } catch (DisabledAccountException e) {
            request.setAttribute("msg", "账户已被禁用");
            return "login";
        } catch (AuthenticationException e) {
            request.setAttribute("msg", "用户名或密码错误");
            return "login";
        }
        // 执行到这里说明用户已登录成功
        return "redirect:/auth/index";

    }


//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String loginPage() {
//        return "login";
//    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String loginSuccessMessage(HttpServletRequest request) {
        String username = "未登录";
//        20180817HRQ
//        SysUser currentLoginUser = RequestUtils.currentLoginUser();
        SysUser currentLoginUser = (SysUser) SecurityUtils.getSubject().getPrincipal();


        if (currentLoginUser != null && StringUtils.isNotEmpty(currentLoginUser.getUserName())) {
            username = currentLoginUser.getUserName();
        } else {
            return "redirect:/auth/login";
        }
        request.setAttribute("username", username);
        System.out.println("fff");
        return "/page/index";
    }

    //被踢出后跳转的页面
    @RequestMapping(value = "/kickout", method = RequestMethod.GET)
    public String kickOut() {
        return "login2";
    }
}
