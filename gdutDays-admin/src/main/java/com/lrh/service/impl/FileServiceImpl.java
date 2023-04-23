package com.lrh.service.impl;

import com.lrh.entity.Result;
import com.lrh.service.FileService;
import com.lrh.service.UserService;
import com.lrh.utils.ErrorMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author lrh
 * @description
 * @date 2023/4/23
 */
@Service
public class FileServiceImpl implements FileService {
    private static final String path = "C:\\Users\\Kssn\\Documents\\HBuilderProjects\\gdutDays\\img\\";

    @Autowired
    private UserService userService;

    @Override
    public Result upload(MultipartFile file) {
        String oldName = file.getOriginalFilename();//QQ图片20210728184110.jpg
        String suffix = oldName.substring(oldName.lastIndexOf('.')+1,oldName.length());

        if(!suffix.equals("jpg") && !suffix.equals("jpeg") && !suffix.equals("png")){
            return Result.fail(ErrorMsg.FILE_ERROR.getCode(),null,ErrorMsg.FILE_ERROR.getMessage());
        }
        long curTime = System.currentTimeMillis()/1000;

        String newName = curTime + "." + suffix;

        try {
            file.transferTo(new File(path+newName));
        } catch (IOException e) {
            e.printStackTrace();
            return Result.fail(ErrorMsg.FILE_ERROR.getCode(),null,ErrorMsg.FILE_ERROR.getMessage());
        }
        userService.changeAvatar("img/" + newName);
        return Result.success(newName);
    }
}
