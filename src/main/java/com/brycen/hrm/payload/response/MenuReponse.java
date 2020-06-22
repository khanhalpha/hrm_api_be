package com.brycen.hrm.payload.response;

public class MenuReponse {

    private Long screenid;
    private String screenURL;
    private String icon;
    private boolean isHide;
    
    public Long getScreenid() {
        return screenid;
    }
    public void setScreenid(Long screenid) {
        this.screenid = screenid;
    }
    public String getScreenURL() {
        return screenURL;
    }
    public void setScreenURL(String screenURL) {
        this.screenURL = screenURL;
    }
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public boolean isHide() {
        return isHide;
    }
    public void setHide(boolean isHide) {
        this.isHide = isHide;
    }
}
