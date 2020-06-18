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
@Table(name = "role_screen")
public class RoleScreen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rolescreen_id")
    private long rolescreenId;
    
    @ManyToOne 
    @JoinColumn(name = "role_id")
    private Role role;  
// 
    @ManyToOne 
    @JoinColumn(name = "screen_id")
    private Screen screen;
    
    @Column(name = "access", columnDefinition = "boolean default false")
    private boolean access ;   

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "roleScreen")
    private List<RoleScreenAction> listAction;
    
    public RoleScreen()
    {
        
    }
    
    public RoleScreen(Role role, Screen screen)
    {
        this.role = role;
        this.screen = screen;
    }
    
//    public long getRolescreenId() {
//        return rolescreenId;
//    }
    public void setRolescreenId(long rolescreenId) {
        this.rolescreenId = rolescreenId;
    }
//    public Role getRole() {
//        return role;
//    }
    public void setRole(Role role) {
        this.role = role;
    }
    public Screen getScreen() {
        return screen;
    }
    public void setScreen(Screen screen) {
        this.screen = screen;
    }
    
    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }
    
    public List<RoleScreenAction> getListAction() {
        return listAction;
    }

    public void setListAction(List<RoleScreenAction> listAction) {
        this.listAction = listAction;
    }
}
