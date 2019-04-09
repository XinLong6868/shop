package com.fh.shop.backend.controller.photo;

import com.fh.shop.backend.biz.photo.IPhotoService;
import com.fh.shop.backend.po.photo.PhotoInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;


@Controller

public class PhotoInfoController{
    @Resource(name = "photoService")
    private IPhotoService photoService;

    @RequestMapping("/photo/findProductList")
    public String findProductList(ModelMap photoMap,Integer id){
        List<PhotoInfo>photoList=photoService.findProductList(id);
        photoMap.put("photoList",photoList);
        return "photo/photoList";
    }

}
