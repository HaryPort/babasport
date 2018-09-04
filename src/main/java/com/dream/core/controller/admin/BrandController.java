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
 * @author Harry
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

        StringBuilder params = new StringBuilder();

        Brand brand = new Brand();
        //isBlank: "" "   " 都是空串
        //isEmpty: ""空串, "  "不是空串
        if (StringUtils.isNotBlank(name)) {
            brand.setName(name);
            params.append("name=").append(name);
        }

        if(isDisplay != null){
            brand.setIsDisplay(isDisplay);
            params.append("&").append("isDisplay=").append(isDisplay);
        }else{
            params.append("&").append("isDisplay=").append(1);
        }


        //Pagination.cpn(1): 页号如果为null 或者小于1. 都将设置为1
        brand.setPageNo(Pagination.cpn(pageNo));
        //每页数
        brand.setPageSize(5);

        Pagination brandListWithPage = brandService.getBrandListWithPage(brand);

        //分页展示 /brand/list.do?name=xxxx & idDisplay=1 &pageNo=2
        String url = "/brand/list.do";
        brandListWithPage.pageView(url, params.toString());

        // 返回页面
        modelMap.addAttribute("pagination", brandListWithPage);
        modelMap.addAttribute("name", name);
        modelMap.addAttribute("isDisplay", isDisplay);
        return "brand/list";
    }

    /**
     * 跳转品牌添加页面
     */
    @RequestMapping(value = "/toAdd.do")
    public String toAdd(){
        return "brand/add";
    }


    /**
     * 添加品牌
     * @return
     */
    @RequestMapping(value = "/add.do")
    public String add(Brand brand){
        brandService.addBrand(brand);
        return "redirect:/brand/list.do";
    }

    /**
     * 删除一个品牌
     * @param id
     * @param name
     * @param isDisplay
     * @return
     */
    @RequestMapping(value = "/delete.do")
    public String delete (Integer id, String name, String isDisplay, ModelMap model){

        //删除
        brandService.deleteBrandByKey(id);

        if(StringUtils.isNotBlank(name)){
            model.addAttribute("name", name);
        }

        if(isDisplay != null){
            model.addAttribute("isDisplay", isDisplay);
        }

        return "redirect:/brand/list.do";
    }

}
