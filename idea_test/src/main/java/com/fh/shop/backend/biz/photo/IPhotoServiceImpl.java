package com.fh.shop.backend.biz.photo;


import com.fh.shop.backend.mapper.photo.IPhotoMapper;
import com.fh.shop.backend.po.photo.PhotoInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("photoService")
public class IPhotoServiceImpl implements IPhotoService{

    @Autowired
    private IPhotoMapper iPhotoMapper;
    @Override
    public void addPhotoInfo(PhotoInfo photoInfo) {
        iPhotoMapper.addPhotoInfo(photoInfo);
    }

    @Override
    public List<PhotoInfo> findProductList(Integer id) {
        List<PhotoInfo> productImageList = iPhotoMapper.findProductList(id);
        return productImageList;
    }

    @Override
    public void deleteChildImage(List<Integer> idsList) {
        iPhotoMapper.deleteChildImage(idsList);
    }

}
