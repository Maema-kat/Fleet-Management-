package com.fleetmanagement.backend.dto;

public class ManagerResponse {
    private String department ;

    private Long userId ;

    public ManagerResponse() {}

    public ManagerResponse(String department,Long userId) {
        this.department=department;

        this.userId = userId;
    }
    public String getDepartment(){
        return department;
    }

    public Long getUserId() {
        return userId;
    }

}
