package com.dream.core.dao;

import com.dream.core.bean.TestTb;
import com.dream.core.service.TestTbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * 测试service层
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class TestTestTb {

    @Autowired
    private TestTbService testTbService;

    @Test
    public void testAdd() {
        //Alt + Shift + L: 快速返回类型

        TestTb testTb = new TestTb();
        testTb.setName("金乐乐");
        testTb.setBirthday(new Date());

        testTbService.addTestTb(testTb);
    }
}
