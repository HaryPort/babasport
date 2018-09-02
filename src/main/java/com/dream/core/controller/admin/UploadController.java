package com.dream.core.controller.admin;

import com.dream.common.web.ResponseUtils;
import com.dream.core.web.Constants;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 上传图片
 * 1. 商品 上传
 * 2. 品牌 上传
 * 3. 商品介绍fck上传
 *
 * @author Harry
 */
@Controller
public class UploadController {

    @RequestMapping(value = "/upload/uploadPic.do")
    public void uploadPic(@RequestParam(required = false) MultipartFile pic, HttpServletResponse response) {

        //图片名称生成策略
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        //图片名称的一部分
        String format = dateFormat.format(new Date());
        //随机三个数
        Random r = new Random();
        for (int i = 0; i < 3; i++) {
            format += r.nextInt(10);
        }

        //获取后缀名, 扩展名
        String extension = FilenameUtils.getExtension(pic.getOriginalFilename());

        //实例化Jersey
        Client client = new Client();
        //另一台服务器的请求
        String path = "upload/" + format + "." + extension;
        String url = Constants.IMGAE_URL + path;
        //设置请求路径
        WebResource resource = client.resource(url);
        //发送开始: POST GET, 基于PUT 提交
        try {
            resource.put(String.class, pic.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //返回两个路径
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("url", url);
        jsonObject.put("path", path);

        ResponseUtils.senderJson(jsonObject.toString(), response);
    }


}
