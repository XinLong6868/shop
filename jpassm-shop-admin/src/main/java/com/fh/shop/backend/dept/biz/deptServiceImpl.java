package com.fh.shop.backend.dept.biz;

import com.fh.shop.backend.dept.mapper.IDeptMapper;
import com.fh.shop.backend.dept.po.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("deptService")
public class deptServiceImpl implements IDeptService {
    @Autowired
    private IDeptMapper deptMapper;
    /**
     * 查看部门信息
     * @return
     */
    @Override
    public List<Dept> findDeptList() {
        List<Dept> deptList = deptMapper.findAll();
        return deptList;
    }

    /**
     * 添加部门
     * @param dept
     */
    @Override
    public void save(Dept dept) {
        deptMapper.save(dept);
    }

    /**
     * 删除部门
     * @param ids
     */
    @Override
    public void deleteDept(List<Integer> ids) {
        deptMapper.deleteByIdList(ids);
    }

    /**
     * 修改部门
     * @param dept
     */
    @Override
    public void updateDept(Dept dept) {
        deptMapper.save(dept);
    }
}
