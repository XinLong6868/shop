package com.fh.shop.backend.biz.area;

import com.fh.shop.backend.po.area.AreaInfo;

import java.util.List;

public interface IAreaService {
    List<AreaInfo> findAreaList();

    void deleteAreaInfo(List<Integer> ids);

    void updateListAreaInfo(AreaInfo areaInfo);

    void addListAreaInfo(AreaInfo areaInfo);
}
