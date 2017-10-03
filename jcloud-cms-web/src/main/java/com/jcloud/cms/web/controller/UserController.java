package com.jcloud.cms.web.controller;

import com.jcloud.cms.common.utils.MD5Utils;
import com.jcloud.cms.dao.UserMapper;
import com.jcloud.cms.domain.User;
import com.jcloud.cms.service.UserService;
import com.jcloud.cms.web.base.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by BurNing on 17/10/3.
 */
@Controller("UserController")
@RequestMapping("/user")
public class UserController extends BaseController {

    @RequestMapping("/login")
    public String login(){
        return "redirect:/login.html";

    }

    @RequestMapping("/regisgter")
    public String register(){
        User user = new User();
        user.setPhone("18513955321");
        user.setUserName("dangyuanchao");
        user.setStatus(1);
        user.setPassword(MD5Utils.GetMD5Code("123456"));
        userService.addUser(user);
        return "redirect:/login.html";

    }
}
