package com.brycen.hrm.payload.response;

import java.util.List;

import com.brycen.hrm.model.RoleScreen;

public class ScreenReponse {

    private Long screenId;

    private String screenName;

    private String screenURL;
    
    public Long getId() {
        return screenId;
    }
    
    private List<RoleScreen> roleScreens;

    public List<RoleScreen> getRoleScreens() {
        return roleScreens;
    }

    public void setRoleScreens(List<RoleScreen> roleScreens) {
        this.roleScreens = roleScreens;
    }

    public void setId(Long screenId) {
        this.screenId = screenId;
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
}
