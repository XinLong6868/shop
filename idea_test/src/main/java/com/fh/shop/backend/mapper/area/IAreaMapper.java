package com.fh.shop.backend.mapper.area;

import com.fh.shop.backend.po.area.AreaInfo;

import java.util.List;

public interface IAreaMapper {
    List<AreaInfo> findAreaList();

    void deleteAreaInfo(List<Integer> ids);

    void updateListAreaInfo(AreaInfo areaInfo);

    void addListAreaInfo(AreaInfo areaInfo);
}
