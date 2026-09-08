package com.fleetmanagement.backend.service;

import com.fleetmanagement.backend.entity.Manager;
import com.fleetmanagement.backend.repository.ManagerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {
    private final ManagerRepository managerRepository;

    public ManagerService (ManagerRepository managerRepository){
        this.managerRepository =managerRepository;
    }

    public Manager createManager (Manager manager)
    {

        return managerRepository.save(manager);
    }

    public List <Manager> getAllManagers () {return managerRepository.findAll();}

    public Manager getManagerById (Long id) {
        return managerRepository.findById(id).orElseThrow(() ->(new RuntimeException("Manager not found")));
    }
    public Manager updateManager(Long id,Manager updatedManager) {
        Manager existingManager  = managerRepository.findById(id).orElseThrow(() -> new RuntimeException("No manager found"));

        existingManager.setDepartment(updatedManager.getDepartment());
        existingManager.setName(updatedManager.getName());

        return managerRepository.save(existingManager);

    }
    public void deleteManager(Long id) {
        Manager manager = managerRepository.findById(id).orElseThrow(()-> new RuntimeException("No driver found"));
        managerRepository.delete(manager);
    }


}
