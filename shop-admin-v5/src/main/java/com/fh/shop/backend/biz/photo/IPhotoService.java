package com.fh.shop.backend.biz.photo;

import com.fh.shop.backend.po.photo.PhotoInfo;

import java.util.List;

public interface IPhotoService {
    public void addPhotoInfo(PhotoInfo photoInfo);

    List<PhotoInfo> findProductList(Integer id);

    void deleteChildImage(List<Integer> idsList);
}
