package com.lrh.controller;

import com.lrh.entity.Result;
import com.lrh.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author lrh
 * @description
 * @date 2023/4/23
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;


    @RequestMapping("/upload")
    public Result upload(MultipartFile file){
        return fileService.upload(file);
    }
}
