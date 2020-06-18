package com.brycen.hrm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "action_role_screen_action")
public class ActionRoleScreenAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "action_role_screen_action_id")
    private Long actionRoleScreenActionId;

    @ManyToOne 
    @JoinColumn(name = "action_id")
    private Action action;  
    
    @ManyToOne 
    @JoinColumn(name = "rolescreenaction_id")
    private RoleScreenAction roleScreenAction;
    
    public Long getActionRoleScreenActionId() {
        return actionRoleScreenActionId;
    }

    public void setActionRoleScreenActionId(Long actionRoleScreenActionId) {
        this.actionRoleScreenActionId = actionRoleScreenActionId;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public RoleScreenAction getRoleScreenAction() {
        return roleScreenAction;
    }

    public void setRoleScreenAction(RoleScreenAction roleScreenAction) {
        this.roleScreenAction = roleScreenAction;
    }

}
