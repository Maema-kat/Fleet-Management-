package com.fleetmanagement.backend.entity;
import com.fleetmanagement.backend.entity.Driver;
import com.fleetmanagement.backend.entity.Vehicle;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name ="vehicle_requests")
public class VehicleRequest {

    private Driver driver;
    private Vehicle vehicle ;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;
    private Date requestDate ;
    private Date startDate;
    private Date endDate;
    private String reason;
    private String status ;

    public VehicleRequest() {}

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
