package com.jcloud.cms.web.controller;

import com.jcloud.cms.web.base.controller.BaseController;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by BurNing on 16/9/30.
 */
@Controller("FileuploadController")
@RequestMapping("/cms")
public class FileuploadController extends BaseController{

    private static final Logger logger = Logger.getLogger(FileuploadController.class);

    @RequestMapping("/upload")
    public String upload(){
        return "redirect:/login.html";

    }
}
