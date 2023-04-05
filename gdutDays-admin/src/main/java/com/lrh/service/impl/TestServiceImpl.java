package com.lrh.service.impl;
import com.lrh.dao.TestDao;
import com.lrh.entity.Result;
import com.lrh.entity.Test;
import com.lrh.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lrh
 * @description
 * @date 2023/2/10
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    public Result test() {
        Test test = testDao.selectById(1);

        return Result.success(test);
    }
}
