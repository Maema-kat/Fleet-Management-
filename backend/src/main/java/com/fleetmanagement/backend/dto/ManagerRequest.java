package com.fleetmanagement.backend.dto;

public class ManagerRequest {
    private String department;
    private Long userId;

    public String getDepartment(){return department;}
    public void setDepartment(String department) {this.department =department;}

    public Long getUserId() {return userId;}
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
