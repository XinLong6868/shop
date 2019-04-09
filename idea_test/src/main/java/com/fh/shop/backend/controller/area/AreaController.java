package com.fh.shop.backend.controller.area;


import com.fh.shop.backend.biz.area.IAreaService;
import com.fh.shop.backend.common.ServerResponse;
import com.fh.shop.backend.po.area.AreaInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/*声明这是个控制层*/
@Controller

public class AreaController {
    /*将service引入*/
    @Autowired
    @Qualifier("iAreaService")
    private IAreaService iAreaService;

    /**
     *
     * 点击地区管理跳转到地区前台，通过里面的ajax方法
     */
    @RequestMapping("area/listAreaInfo")
    public String listAreaInfo(){
        return "area/areaList";
    }
    /*查询方法*/
    @RequestMapping("area/findAreaList")
    @ResponseBody
    public ServerResponse findAreaList(){
        /*定义个List集合，将查询出的数据放入*/
        List<AreaInfo> areaInfoList = iAreaService.findAreaList();
        /*将查询出的对象响应到前台*/
        return ServerResponse.success(areaInfoList);
    }
    /**
     * 删除方法
     */
    @RequestMapping("area/deleteAreaInfo")
    @ResponseBody
    public ServerResponse deleteAreaInfo(@RequestParam("ids[]") List<Integer> ids){
        iAreaService.deleteAreaInfo(ids);
        return ServerResponse.success();
    }
    /**
     * 修改方法
     */
    @RequestMapping("area/updateListAreaInfo")
    @ResponseBody
    public ServerResponse updateListAreaInfo(AreaInfo areaInfo){
        iAreaService.updateListAreaInfo(areaInfo);
        return ServerResponse.success();
    }
    /**
     * 增加方法
     */
    @RequestMapping("area/addListAreaInfo")
    @ResponseBody
    public ServerResponse addListAreaInfo(AreaInfo areaInfo){
        iAreaService.addListAreaInfo(areaInfo);
        return ServerResponse.success(areaInfo.getId());
    }
}
