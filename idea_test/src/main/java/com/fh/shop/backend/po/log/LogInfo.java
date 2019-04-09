package com.fh.shop.backend.po.log;

import java.io.Serializable;
import java.util.Date;

public class LogInfo implements Serializable {
    private static final long serialVersionUID = 5917716413449272554L;

    private Long id;

    private String userName;

    private String info;

    private Date createTime;

    private int excuteTime;

    private int status;

    public String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getExcuteTime() {
        return excuteTime;
    }

    public void setExcuteTime(int excuteTime) {
        this.excuteTime = excuteTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
