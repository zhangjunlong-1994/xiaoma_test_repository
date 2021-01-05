package com.pony.sc_home_personal.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author chujialin
 * @date 2019/11/20 16:40
 **/
@FeignClient(name = "es")
public interface ImageFeign {

    /**
     * 获取图片
     *
     * @param path 图片路径
     * @return 图片
     */
    @PostMapping("/getImage.do")
    byte[] getImage(@RequestParam("path") String path);

    /**
     * 删除图片
     *
     * @param name 图片名称
     * @param path 图片路径
     * @return 是否成功
     */
    @PostMapping("/DeleteImage.do")
    String deleteImage(@RequestParam("name") String name, @RequestParam("path") String path);

    /**
     * 上传临时图片
     *
     * @param file 图片
     * @return 图片名称
     */
    @PostMapping(value = "/UploadShortTimeImage.do", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String uploadShortTimeImage(@RequestPart("file") MultipartFile file);

    /**
     * 删除临时图片
     *
     * @param imgName 图片名称
     */
    @PostMapping("/DeleteShortTimeImage.do")
    void deleteShortTimeImage(@RequestParam("imgName") String imgName);

    /**
     * 转存临时图片为正式图片
     *
     * @param imgName 图片名称
     * @param path    存储路径
     */
    @PostMapping("/TransferShortTimeImage.do")
    String transferShortTimeImage(@RequestParam("imgName") String imgName, @RequestParam("path") String path);

    /**
     * 删除所有临时图片
     */
    @GetMapping("/DeleteShortTimeImgAll.do")
    void deleteShortTimeImgAll();
}
