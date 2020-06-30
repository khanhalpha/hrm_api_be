package com.brycen.hrm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "project_name")
    @NotNull
    @NotEmpty
    private String projectName;
    
    @Column(name = "project_code")
    @NotNull
    @Min(value = 18)
    @Max(value = 150)
    private Long projectCode;

    @Size(min = 3, max = 35)
    private String surName;   
    
    @Email 
    private String email;

    @PositiveOrZero() 
    private Integer numberOfMember;
    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(Long projectCode) {
        this.projectCode = projectCode;
    }
    
    
    public Integer getNumberOfMember() {
        return numberOfMember;
    }

    public void setNumberOfMember(Integer numberOfMember) {
        this.numberOfMember = numberOfMember;
    }
    
    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }
}
