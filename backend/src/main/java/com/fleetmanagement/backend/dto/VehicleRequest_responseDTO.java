package com.fleetmanagement.backend.dto;

import java.util.Date;

public class VehicleRequest_responseDTO {
    private Long requestId;
    private Date requestDate ;
    private Date startDate;
    private Date endDate;
    private String reason;
    private String status ;

    public VehicleRequest_responseDTO(Long requestId,Date requestDate,Date startDate,Date endDate,String reason,String status) {
        this.requestId =requestId;
        this.requestDate = requestDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.status = status;
    }

    public Long getRequestId() {return requestId;}
    public Date getRequestDate() {return requestDate;}
    public Date getStartDate() {return startDate;}
    public Date getEndDate() {return endDate;}
    public String getReason() {return reason;}
    public String getStatus() {return status ;}
}
