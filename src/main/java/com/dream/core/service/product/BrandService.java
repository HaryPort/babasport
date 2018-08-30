package com.dream.core.service.product;

import cn.itcast.common.page.Pagination;
import com.dream.core.bean.product.Brand;

public interface BrandService {
    Pagination getBrandListWithPage(Brand brand);
}
