package com.fleetmanagement.backend.dto;

import com.fleetmanagement.backend.entity.Mechanic;
import com.fleetmanagement.backend.entity.Vehicle;

import java.time.LocalDate;
import java.util.Date;

public class MaintenanceResponse {


        private Long id;
        private Long vehicleId;
        private Long mechanicId;
        private Date maintenanceDate;
        private String description;
        private int cost;
        private Double odometer;
        private String status;

        public MaintenanceResponse() {
        }

        public MaintenanceResponse(
                Long id,
                Long vehicleId,
                Long mechanicId,
                Date maintenanceDate,
                String description,
                int cost,
                Double odometer,
                String status) {

            this.id = id;
            this.vehicleId = vehicleId;
            this.mechanicId = mechanicId;
            this.maintenanceDate = maintenanceDate;
            this.description = description;
            this.cost = cost;
            this.odometer = odometer;
            this.status = status;
        }
    public Long getId() {return id ;}
    public Long getVehicleId() {return vehicleId;}
    public Date getMaintenanceDate() {return maintenanceDate;}
    public String getDescription() {return description;}
    public int getCost() {return  cost ;}
    public String getStatus() {return status;}
    public Long getMechanicId() {return mechanicId;}
    public double getOdometer() {return  odometer;}
    }

