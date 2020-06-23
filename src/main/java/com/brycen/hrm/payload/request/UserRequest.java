package com.brycen.hrm.payload.request;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class UserRequest {

    @Size(min = 3, max = 20)
    private String username;
 

    @Size(max = 50)
    @Email
    private String email;
    
    private List<String> roles;
    
    @Size(min = 6, max = 40)
    private String password;
  
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public List<String> getRoles() {
      return this.roles;
    }
    
    public void setRoles(List<String> roles) {
      this.roles = roles;
    }
}
