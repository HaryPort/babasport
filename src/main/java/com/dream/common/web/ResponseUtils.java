package com.dream.common.web;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 异步返回各种格式(json xml text)
 *
 * @author Harry
 */
public class ResponseUtils {

    /**
     * 发送内容
     */
    public static void sender(String text, String contentType, HttpServletResponse response) {
        response.setContentType(contentType);

        try {
            response.getWriter().write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送json
     * @param text
     * @param response
     */
    public static void senderJson(String text, HttpServletResponse response){
        sender(text, "application/json;charset=UTF-8", response);
    }

    /**
     * 发送xml
     * @param text
     * @param response
     */
    public static void senderXML(String text, HttpServletResponse response){
        sender(text, "text/xml;charset=UTF-8", response);
    }

    /**
     * 发送普通文本
     * @param text
     * @param response
     */
    public static void senderText(String text, HttpServletResponse response){
        sender(text, "text/plain;charset=UTF-8", response);
    }
}
