package com.dream.core.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 模块加载
 */
@Controller
@RequestMapping(value = "/control")
public class FrameController {

    /**
     * 商品的身体
     *
     * @return
     */
    @RequestMapping(value = "/frame/product_main.do")
    public String productMain() {
        return "frame/product_main";
    }

    /**
     * 商品的左边身体
     *
     * @return
     */
    @RequestMapping(value = "/frame/product_left.do")
    public String productleft() {
        return "frame/product_left";
    }

    /**
     * 订单的身体
     *
     * @return
     */
    @RequestMapping(value = "/frame/order_main.do")
    public String orderMain() {
        return "frame/order_main";
    }

    /**
     * 订单的左边身体
     *
     * @return
     */
    @RequestMapping(value = "/frame/order_left.do")
    public String orderleft() {
        return "frame/order_left";
    }

}
