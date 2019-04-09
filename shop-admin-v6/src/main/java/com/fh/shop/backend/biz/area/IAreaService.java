package com.fh.shop.backend.biz.area;

import com.fh.shop.backend.po.area.Area;

import java.util.List;

public interface IAreaService {
    List<Area> queryAreaList();

    void deleteArea(List<Integer> ids);

    void addArea(Area area);

    void updateArea(Area area);
}
