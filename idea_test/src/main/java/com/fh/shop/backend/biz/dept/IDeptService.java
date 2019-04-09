package com.fh.shop.backend.biz.dept;

import com.fh.shop.backend.po.dept.DeptInfo;

import java.util.List;

public interface IDeptService {
    List<DeptInfo> findList();

    void addListDeptInfo(DeptInfo deptInfo);

    void deleteDeptInfo(List<Integer> ids);

    void updateListDeptInfo(DeptInfo deptInfo);
}
