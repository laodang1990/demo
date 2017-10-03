package com.jcloud.cms.web.base.controller;

import com.jcloud.cms.service.UserService;

import javax.annotation.Resource;

/**
 * Created by dangyuanchao on 2016/2/18.
 */
public class BaseController {

    @Resource
    protected UserService userService;

}
