package com.fh.shop.backend.mapper.photo;

import com.fh.shop.backend.po.photo.PhotoInfo;

import java.util.List;

public interface IPhotoMapper {
    void addPhotoInfo(PhotoInfo photoInfo);

    List<PhotoInfo> findProductList(Integer id);

    void deleteChildImage(List<Integer> idsList);
}
