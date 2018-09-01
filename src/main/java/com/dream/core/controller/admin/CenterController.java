package com.dream.core.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * @author Harry
 * 后台管理Controller
 */
@Controller
@RequestMapping(value = "/control")
public class CenterController {

    /**
     * 后台跳转页面
     */
    @RequestMapping(value = "/index.do")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/top.do")
    public String top() {
        return "top";
    }

    @RequestMapping(value = "/main.do")
    public String main() {
        return "main";
    }

    @RequestMapping(value = "/left.do")
    public String left() {
        return "left";
    }

    @RequestMapping(value = "/right.do")
    public String right() {
        return "right";
    }

    @RequestMapping(value = "/test/springmvc.do", method = RequestMethod.POST)
    public String test(String name, Date birthday) {
        System.out.println(birthday);
        return "";
    }

    /*@InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }*/
}
