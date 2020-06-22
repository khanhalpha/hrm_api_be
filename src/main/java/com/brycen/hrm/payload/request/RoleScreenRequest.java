package com.brycen.hrm.payload.request;

public class RoleScreenRequest {

    private Long screenid;
    private Integer roleid;
    private boolean access;
    
    public Long getScreenid() {
        return screenid;
    }
    public void setScreenid(Long screenid) {
        this.screenid = screenid;
    }
    public Integer getRoleid() {
        return roleid;
    }
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
    public boolean isAccess() {
        return access;
    }
    public void setAccess(boolean access) {
        this.access = access;
    }
}
