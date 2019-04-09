package com.fh.shop.backend.dept.web.controller;

import com.fh.shop.backend.common.ServerResponse;
import com.fh.shop.backend.dept.biz.IDeptService;
import com.fh.shop.backend.dept.po.Dept;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Resource(name="deptService")
    private IDeptService deptService;
    /**
     *查看部门信息
     * @return
     */
    @RequestMapping("/findDeptList")
    public ServerResponse findDeptList(){
        List<Dept> deptList = deptService.findDeptList();
        return ServerResponse.success(deptList);
    }


    /**
     * 添加部门
     * @param dept
     * @return
     */
   @RequestMapping("addDept")
    public ServerResponse addDept(Dept dept){
        deptService.save(dept);
        return ServerResponse.success(dept.getId());
    }

    /**
     * 删除部门
     * @return
     */
    @RequestMapping("deleteDept")
    public ServerResponse deleteDept(@RequestParam("ids[]")List<Integer> ids){
        deptService.deleteDept(ids);
        return ServerResponse.success();
    }

    /**
     * 修改部门
     * @return
     */
   @RequestMapping("updateDept")
    public ServerResponse updateDept(Dept dept){
        deptService.updateDept(dept);
        return ServerResponse.success();
    }



}
