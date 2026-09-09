package com.fleetmanagement.backend.service;
import com.fleetmanagement.backend.repository.VehicleRequestRepository;
import com.fleetmanagement.backend.entity.VehicleRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VehicleRequest_Service {

    private final VehicleRequestRepository vehicleRequestRepository;

    public VehicleRequest_Service(VehicleRequestRepository vehicleRequestRepository){
        this.vehicleRequestRepository = vehicleRequestRepository;
    }
    public VehicleRequest createVehicleRequest(VehicleRequest vehicleRequest){
        return vehicleRequestRepository.save(vehicleRequest);
    }
    public List<VehicleRequest> getAllVehicleRequests (){
        return vehicleRequestRepository.findAll();
    }
    public VehicleRequest getVehicleRequestById(Long id) {
        return vehicleRequestRepository.findById(id).orElseThrow(()-> new RuntimeException("NOO ID FOUND"));
    }
     public VehicleRequest updateVehicleRequest(Long id ,VehicleRequest updatedvehicleRequest) {
        VehicleRequest existingVehicleRequest  =  vehicleRequestRepository.findById(id).orElseThrow(()-> new RuntimeException("NOO ID FOUND"));

        existingVehicleRequest.setStartDate(updatedvehicleRequest.getStartDate());
        existingVehicleRequest.setEndDate(updatedvehicleRequest.getEndDate());
        existingVehicleRequest.setStatus(updatedvehicleRequest.getStatus());
        existingVehicleRequest.setReason(updatedvehicleRequest.getReason());

        return vehicleRequestRepository.save(existingVehicleRequest);

     }
    public void deleteVehicleRequest(Long id) {
        VehicleRequest vehicleRequest= vehicleRequestRepository.findById(id).orElseThrow(()-> new RuntimeException("NOO ID FOUND"));

         vehicleRequestRepository.delete(vehicleRequest);


    }



}
