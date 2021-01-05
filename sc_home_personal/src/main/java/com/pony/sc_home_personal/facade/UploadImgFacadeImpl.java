package com.pony.sc_home_personal.facade;

import com.pony.sc_home_personal.service.ImageFeign;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author wenxufeng
 * @date 2019/11/26 13:39
 **/
@Component
public class UploadImgFacadeImpl implements UploadImgFacade {

    @Resource
    private ImageFeign imageFeign;

    @Override
    public String uploadShortTimeImage(MultipartFile file) {
        return imageFeign.uploadShortTimeImage(file);
    }

    @Override
    public void deleteShortTimeImage(String imgName) {
        imageFeign.deleteShortTimeImage(imgName);
    }
}
