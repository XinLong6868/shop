package com.fh.shop.backend.biz.area;

import com.fh.shop.backend.mapper.area.IAreaMapper;
import com.fh.shop.backend.po.area.AreaInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iAreaService")
public class IAreaServiceImpl implements IAreaService{
    @Autowired
    private IAreaMapper iAreaMapper;
    /*ztree查询*/
    @Override
    public List<AreaInfo> findAreaList() {
        List<AreaInfo>areaInfoList = iAreaMapper.findAreaList();
        return areaInfoList;
    }
    /*ztree删除*/
    @Override
    public void deleteAreaInfo(List<Integer> ids) {
        iAreaMapper.deleteAreaInfo(ids);
    }
    /*ztree修改*/
    @Override
    public void updateListAreaInfo(AreaInfo areaInfo) {
        iAreaMapper.updateListAreaInfo(areaInfo);
    }
    /*ztree增加*/
    @Override
    public void addListAreaInfo(AreaInfo areaInfo) {
        iAreaMapper.addListAreaInfo(areaInfo);
    }
}
