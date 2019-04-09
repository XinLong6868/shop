package com.fh.shop.backend.mapper.dept;

import com.fh.shop.backend.po.dept.DeptInfo;

import java.util.List;

public interface IDeptMapper {
    List<DeptInfo> findList();

    void addListDeptInfo(DeptInfo deptInfo);

    void deleteDeptInfo(List<Integer> ids);

    void updateListDeptInfo(DeptInfo deptInfo);
}
