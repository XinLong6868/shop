package com.fh.shop.backend.controller.dept;

import com.fh.shop.backend.biz.dept.IDeptService;
import com.fh.shop.backend.common.ServerResponse;
import com.fh.shop.backend.po.dept.DeptInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//声明控制层
@Controller
@ResponseBody
public class DeptController {
    //引入service接口
    @Autowired
    @Qualifier("iDeptService")
    private IDeptService iDeptService;

    //查询方法
    @RequestMapping("/dept/findList")
    public ServerResponse findList() {
        List<DeptInfo> deptInfoList = iDeptService.findList();
        return ServerResponse.success(deptInfoList);
    }
    /**
     * 增加方法
     */
    @RequestMapping("/dept/addListDeptInfo")
    public ServerResponse addListDeptInfo(DeptInfo deptInfo){
        iDeptService.addListDeptInfo(deptInfo);
        return ServerResponse.success(deptInfo.getId());
    }
    /**
     * 删除方法
     */
    @RequestMapping("/dept/deleteDeptInfo")
    public ServerResponse deleteDeptInfo(@RequestParam("ids[]") List<Integer> ids){
        iDeptService.deleteDeptInfo(ids);
        return ServerResponse.success();
    }
    /**
     * 修改方法
     */
    @RequestMapping("/dept/updateListDeptInfo")
    public ServerResponse updateListDeptInfo(DeptInfo deptInfo){
        iDeptService.updateListDeptInfo(deptInfo);
        return ServerResponse.success();
    }
}
