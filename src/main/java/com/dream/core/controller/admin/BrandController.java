package com.dream.core.controller.admin;

import cn.itcast.common.page.Pagination;
import com.dream.core.bean.product.Brand;
import com.dream.core.service.product.BrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 品牌
 */
@Controller
@RequestMapping(value = "/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * 品牌列表页面
     */
    @RequestMapping(value = "/list.do")
    public String list(String name, Integer isDisplay, Integer pageNo, ModelMap modelMap) {

        Brand brand = new Brand();
        //isBlank: "" "   " 都是空串
        //isEmpty: ""空串, "  "不是空串
        if (StringUtils.isNotBlank(name)) {
            brand.setName(name);
        }
        brand.setIsDisplay(isDisplay);

        //Pagination.cpn(1): 页号如果为null 或者小于1. 都将设置为1
        brand.setPageNo(Pagination.cpn(pageNo));

        Pagination brandListWithPage = brandService.getBrandListWithPage(brand);

        //返回页面
        modelMap.addAttribute("pagination", brandListWithPage);//request.setAttribute();

        return "brand/list";
    }

}
