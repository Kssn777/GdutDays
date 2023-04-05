package com.lrh.service;

import com.lrh.entity.param.RegisterParam;
import com.lrh.entity.Result;

/**
 * @author lrh
 * @description
 * @date 2023/2/15
 */
public interface RegisterService {
    Result register(RegisterParam registerParam);
}
