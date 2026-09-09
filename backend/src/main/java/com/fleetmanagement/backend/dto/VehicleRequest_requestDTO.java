package com.fleetmanagement.backend.dto;

import java.util.Date;

public class VehicleRequest_requestDTO {
    private Long requestId;
    private Date requestDate ;
    private Date startDate;
    private Date endDate;
    private String reason;
    private String status ;

    public VehicleRequest_requestDTO() {

    }

    public Long getRequestId() {return requestId;}
    public Date getRequestDate() {return requestDate;}
    public Date getStartDate() {return startDate;}
    public Date getEndDate() {return endDate;}
    public String getReason() {return reason;}
    public String getStatus() {return status ;}

    public void setRequestId(Long requestId){this.requestId =requestId;}
    public void setRequestDate(Date requestDate) {this.requestDate=requestDate;}
    public void setStartDate(Date startDate){this.startDate=startDate;}
    public void setEndDate(Date endDate){this.endDate=endDate;}
    public void setReason(String reason){this.reason = reason;}
    public void setStatus(String status ){this.status=status;}

}
