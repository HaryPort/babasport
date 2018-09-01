package com.dream.core.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *  上传图片
 *  1. 商品 上传
 *  2. 品牌 上传
 *  3. 商品介绍fck上传
 * @author Harry
 */
@Controller
public class UploadController {

    @RequestMapping(value = "/upload/uploadPic.do")
    public void uploadPic(@RequestParam(required = false) MultipartFile pic){

        System.out.println(pic.getOriginalFilename());
        System.out.println(pic.getName());
    }


}
