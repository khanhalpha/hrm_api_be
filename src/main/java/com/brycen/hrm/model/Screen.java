package com.brycen.hrm.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "screens")
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "screen_id")
    private Long screenId;

    @Column(name = "screen_name")
    private String screenName;
    
    @Column(name = "screen_url")
    private String screenURL;
    
    public Long getId() {
        return screenId;
    }
    

    @OneToMany(mappedBy = "screen", cascade = CascadeType.ALL)
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
