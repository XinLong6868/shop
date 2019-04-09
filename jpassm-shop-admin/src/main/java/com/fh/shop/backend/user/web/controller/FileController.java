package com.fh.shop.backend.user.web.controller;

import com.fh.shop.backend.common.ServerResponse;

import com.fh.shop.backend.util.COSUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@RestController
public class FileController {

    /**
     * 将文件上传到腾讯云
     * @return
     */
    @PostMapping("file/uploadFile")
    public ServerResponse uploadFile(@RequestParam MultipartFile productImage){
        String filename = productImage.getOriginalFilename();
        InputStream inputStream = null;
        try {
            inputStream = productImage.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String uploadFilePath = COSUtil.fileInputUpload(inputStream, filename);
        return ServerResponse.success(uploadFilePath);
    }
}
