package com.brycen.hrm.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "actions")
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "action_id")
    private Integer actionId;
    
    @Column(name = "action_name")
    private String actionName;

    @Column(name = "action_code")
    private String actionCode;
    
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "action")
//    private List<ActionRoleScreenAction> listAction;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "action")
    private List<RoleScreenAction> action;
    
//    public List<RoleScreenAction> getAction() {
//        return action;
//    }

    public void setAction(List<RoleScreenAction> action) {
        this.action = action;
    }

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

}
