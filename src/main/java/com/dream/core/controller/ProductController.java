package com.dream.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * @author Harry
 * 产品模块
 */
@Controller
public class ProductController {

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
