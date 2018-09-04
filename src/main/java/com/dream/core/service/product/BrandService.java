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

    /**
     * 根据主键删除一个品牌
     * @param id
     */
    void deleteBrandByKey(Integer id);

    /**
     * 根据主键批量删除
     * @param ids
     */
    void deleteBrandByKeys(Integer [] ids);

    /**
     * 修改品牌
     * @param brand
     */
    void updateBrandByKey(Brand brand);
}
