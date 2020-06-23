package com.brycen.hrm.payload.response;

public class CheckMenuReponse {

    private String roleName;
    private boolean access;
    private String screenName;
    private String screenURL;
    private String screenIcon;
    
    public CheckMenuReponse(Object...fields)
    {
        super();
        this.roleName = (String) fields[0];
        this.access = (boolean) fields[1];
        this.screenName = (String) fields[2];
        this.screenURL = (String) fields[3];
        this.screenIcon = (String) fields[4];
    }
    
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getScreenURL() {
        return screenURL;
    }

    public void setScreenURL(String screenURL) {
        this.screenURL = screenURL;
    }

    public String getScreenIcon() {
        return screenIcon;
    }

    public void setScreenIcon(String screenIcon) {
        this.screenIcon = screenIcon;
    }
}
