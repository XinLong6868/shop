package com.fh.shop.backend.biz.dept;

import com.fh.shop.backend.mapper.dept.IDeptMapper;
import com.fh.shop.backend.po.dept.DeptInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iDeptService")
public class IDeptServiceImpl implements IDeptService{
    @Autowired
    private IDeptMapper iDeptMapper;

    @Override
    public List<DeptInfo> findList() {
        List<DeptInfo> deptInfoList = iDeptMapper.findList();
        return deptInfoList;
    }

    @Override
    public void addListDeptInfo(DeptInfo deptInfo) {
        iDeptMapper.addListDeptInfo(deptInfo);
    }

    @Override
    public void deleteDeptInfo(List<Integer> ids) {
        iDeptMapper.deleteDeptInfo(ids);
    }

    @Override
    public void updateListDeptInfo(DeptInfo deptInfo) {
        iDeptMapper.updateListDeptInfo(deptInfo);
    }
}
