package com.fh.shop.backend.po.dept;

import java.io.Serializable;

public class DeptInfo implements Serializable {
    //生成唯一标识的快捷键：alt+enter
    private static final long serialVersionUID = 7761119315528433015L;

    private Integer id;

    //部门名称
    private String deptName;

    //部门描述
    private String remark;

    private Integer pid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
