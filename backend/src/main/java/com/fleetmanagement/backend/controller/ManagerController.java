package com.fleetmanagement.backend.controller;

import com.fleetmanagement.backend.entity.Manager;
import com.fleetmanagement.backend.service.ManagerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/managers")
public class ManagerController {
    private final ManagerService managerService;

    public ManagerController(ManagerService managerService){this.managerService =managerService;}

    @PostMapping
    public Manager createManager (@RequestBody Manager manager){return managerService.createManager(manager);}

    @GetMapping("/{id}")
    public Manager getManagerById (@PathVariable Long id) {return managerService.getManagerById(id);}

    @GetMapping
    public List<Manager> getAllManagers () {return managerService.getAllManagers();}

    @PutMapping("/{id}")
    public Manager updateManager (@PathVariable Long id ,@RequestBody Manager manager) {
        return managerService.updateManager(id ,manager);




    }
    @DeleteMapping("/{id}")
    public void deleteManager (@PathVariable Long id) {
        managerService.deleteManager(id);
    }
}
