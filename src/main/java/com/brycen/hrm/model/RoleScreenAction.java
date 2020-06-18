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
@Table(name = "role_screen_action")
public class RoleScreenAction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rolescreenaction_id")
    private long roleScreenActionId;
    
    @ManyToOne 
    @JoinColumn(name = "rolescreen_id")
    private RoleScreen roleScreen;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "roleScreenAction")
    private List<ActionRoleScreenAction> listAction;
    
    @Column(name = "access", columnDefinition = "boolean default false")
    private boolean access ;  
    
    public long getRoleScreenActionId() {
        return roleScreenActionId;
    }

    public void setRoleScreenActionId(long roleScreenActionId) {
        this.roleScreenActionId = roleScreenActionId;
    }

    public List<ActionRoleScreenAction> getListAction() {
        return listAction;
    }

    public void setListAction(List<ActionRoleScreenAction> listAction) {
        this.listAction = listAction;
    }

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }

}
