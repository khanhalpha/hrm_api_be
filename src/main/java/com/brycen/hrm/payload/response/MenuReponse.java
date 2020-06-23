package com.brycen.hrm.payload.response;

public class MenuReponse {

    private Long screenid;
    private String screenName;
    private String screenURL;
    private String icon;
    private boolean isHide;
    
    public MenuReponse ()
    {
        
    }
    
    public MenuReponse (String screenName, String screenURL, String icon, boolean isHide) {
        //this.screenid = screenId;
        this.screenName = screenName;
        this.screenURL = screenURL;
        this.icon = icon;
        this.isHide = isHide;
    }
    
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
    
    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }
}
