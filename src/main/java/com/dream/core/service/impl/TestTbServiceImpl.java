package com.dream.core.service.impl;

import com.dream.core.bean.TestTb;
import com.dream.core.dao.TestTbDao;
import com.dream.core.service.TestTbService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Harry
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TestTbServiceImpl implements TestTbService {

    @Resource
    private TestTbDao testTbDao;

    /**
     * 测试
     * @param testTb
     */
    @Override
    public void addTestTb(TestTb testTb) {
        testTbDao.addTestTb(testTb);
    }
}
