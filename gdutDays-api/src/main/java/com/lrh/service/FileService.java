package com.lrh.service;

import com.lrh.entity.Result;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author lrh
 * @description
 * @date 2023/4/23
 */
public interface FileService {
    Result upload(MultipartFile file);
}
