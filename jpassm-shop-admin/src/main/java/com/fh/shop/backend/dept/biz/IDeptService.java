package com.fh.shop.backend.dept.biz;

import com.fh.shop.backend.dept.po.Dept;

import java.util.List;

public interface IDeptService {

//查看部门信息
    List<Dept> findDeptList();
//添加部门
    void save(Dept dept);
//删除部门
    void deleteDept(List<Integer> ids);
//修改部门
    void updateDept(Dept dept);
}
