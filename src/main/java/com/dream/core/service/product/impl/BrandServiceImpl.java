package com.dream.core.service.product.impl;

import cn.itcast.common.page.Pagination;
import com.dream.core.bean.product.Brand;
import com.dream.core.dao.product.BrandDao;
import com.dream.core.service.product.BrandService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class BrandServiceImpl implements BrandService {

    @Resource
    private BrandDao brandDao;

    @Transactional(readOnly = true)
    public Pagination getBrandListWithPage(Brand brand) {

        //1: 起始页 startRow = (pageNo - 1) * pageSize
        //2: 每页数
        //3: 总记录数
        Pagination pagination = new Pagination((brand.getPageNo() - 1) * 5, 5, brandDao.getBrandCount(brand));
        pagination.setList(brandDao.getBrandListWithPage(brand));
        return pagination;
    }

}
