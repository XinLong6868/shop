package com.fh.shop.backend.dept.po;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="t_dept")
public class Dept implements Serializable {

    private static final long serialVersionUID = -3976770736949865199L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //部门名
    private String deptName;
    //父节点
    private Integer fatherId;
    //部门描述
    private String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getFatherId() {
        return fatherId;
    }

    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }
}
