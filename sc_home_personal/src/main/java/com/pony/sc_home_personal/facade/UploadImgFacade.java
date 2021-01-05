package com.pony.sc_home_personal.facade;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author wenxufeng
 * @date 2019/11/26 13:38
 **/
public interface UploadImgFacade {

    /**
     * @author wenxufeng
     * @date 2019/11/26 13:42
     **/
    String uploadShortTimeImage(MultipartFile file);

    /**
     * @author wenxufeng
     * @date 2019/11/26 13:42
     **/
    void deleteShortTimeImage(String imgName);
}
