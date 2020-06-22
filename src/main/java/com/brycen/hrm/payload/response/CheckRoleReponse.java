package com.brycen.hrm.payload.response;

public class CheckRoleReponse {

    private String name;
    private boolean access;
    
    public CheckRoleReponse(Object...fields)
    {
        super();
        this.name = (String) fields[0];
        this.access = (boolean) fields[1];
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isAccess() {
        return access;
    }
    public void setAccess(boolean access) {
        this.access = access;
    }
    
}
