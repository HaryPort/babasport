package com.dream.core.dao.product;

import com.dream.core.bean.product.Brand;

import java.util.List;

/**
 * 品牌dao接口
 */
public interface BrandDao {
    
    List<Brand> getBrandListWithPage(Brand brand);

    //查询总记录数
    int  getBrandCount(Brand brand);
}
