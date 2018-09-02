package com.dream.core.service.product;

import cn.itcast.common.page.Pagination;
import com.dream.core.bean.product.Brand;

/**
 * @author Harry
 */
public interface BrandService {
    /**
     * 分页获取品牌列表
     * @param brand
     * @return
     */
    Pagination getBrandListWithPage(Brand brand);

    /**
     * 添加品牌
     * @param brand
     */
    void addBrand(Brand brand);
}
