package com.pony.sc_home_personal.controller;

import com.pony.sc_home_personal.config.CheckToken;
import com.pony.sc_home_personal.facade.UploadImgFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传
 *
 * @author wenxufeng
 * @date 2019/11/26 13:43
 **/
@RestController
@RequestMapping("/UploadImg")
public class UploadImgController {
    private final UploadImgFacade uploadImgFacade;

    @Autowired
    public UploadImgController(UploadImgFacade uploadImgFacade) {
        this.uploadImgFacade = uploadImgFacade;
    }

    /**
     * 上传临时文件
     *
     * @param file 文件
     * @author wenxufeng
     * @date 2019/11/26 13:44
     **/
    @CheckToken
    @PostMapping("/UploadShortTimeImage.do")
    public String uploadShortTimeImage(@RequestParam MultipartFile file) {
        return uploadImgFacade.uploadShortTimeImage(file);
    }

    /**
     * 删除临时文件
     *
     * @param imgName 临时文件名
     * @author wenxufeng
     * @date 2019/11/26 13:45
     **/
    @CheckToken
    @PostMapping("/DeleteImg.do")
    public void deleteImg(String imgName) {
        uploadImgFacade.deleteShortTimeImage(imgName);
    }
}
