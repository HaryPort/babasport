package com.dream.core.service.product.impl;

import cn.itcast.common.page.Pagination;
import com.dream.core.bean.product.Brand;
import com.dream.core.dao.product.BrandDao;
import com.dream.core.service.product.BrandService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Harry
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BrandServiceImpl implements BrandService {

    @Resource
    private BrandDao brandDao;

    /**
     * 分页去取品牌列表
     *
     * @param brand
     * @return
     */
    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public Pagination getBrandListWithPage(Brand brand) {

        //1: 起始页 startRow = (pageNo - 1) * pageSize
        //2: 每页数
        //3: 总记录数
        Pagination pagination = new Pagination(brand.getPageNo(), brand.getPageSize(), brandDao.getBrandCount(brand));
        pagination.setList(brandDao.getBrandListWithPage(brand));
        return pagination;
    }

}
