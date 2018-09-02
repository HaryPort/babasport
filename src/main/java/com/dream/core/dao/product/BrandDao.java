package com.dream.core.dao.product;

import com.dream.core.bean.product.Brand;

import java.util.List;

/**
 * @author Harry
 * 品牌dao接口
 */
public interface BrandDao {

    /**
     * 分页获取品牌列表
     * @param brand
     * @return
     */
    List<Brand> getBrandListWithPage(Brand brand);

    /**
     * 查询总记录数
     * @param brand
     * @return
     */
    int getBrandCount(Brand brand);

    /**
     * 添加品牌
     */
    void addBrand(Brand brand);
}
