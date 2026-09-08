package com.fleetmanagement.backend.service;

import com.fleetmanagement.backend.entity.Mechanic;
import com.fleetmanagement.backend.repository.MechanicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MechanicService {
    private final MechanicRepository mechanicRepository;

    public MechanicService(MechanicRepository mechanicRepository) {
        this.mechanicRepository = mechanicRepository;
    }

    public Mechanic createMechanic(Mechanic mechanic) {
        return mechanicRepository.save(mechanic);
    }

    public List<Mechanic> getAllMechanics() {
        return mechanicRepository.findAll();
    }

    public Mechanic getMechanicById(Long id) {
        return mechanicRepository.findById(id).orElseThrow(() -> new RuntimeException("DRIVER ID NOT FOUND"));
    }

    public Mechanic updateMechanic(Long id, Mechanic updatedMechanic) {
        Mechanic existingMechanic = mechanicRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));

        existingMechanic.setEmployeeNumber(updatedMechanic.getEmployeeNumber());
        existingMechanic.setName(updatedMechanic.getName());

        return mechanicRepository.save(existingMechanic);
    }
    public void deleteMechanic (Long id) {
        Mechanic mechanic =mechanicRepository.findById(id).orElseThrow(() -> new RuntimeException("NOT FOUND"));

        mechanicRepository.delete(mechanic);
    }
}


