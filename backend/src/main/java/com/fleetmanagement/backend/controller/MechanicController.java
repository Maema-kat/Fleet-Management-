package com.fleetmanagement.backend.controller;
import com.fleetmanagement.backend.entity.Mechanic;
import com.fleetmanagement.backend.service.MechanicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
 @RestController
 @RequestMapping("api/mechanics")
public class MechanicController {
     private final MechanicService mechanicService;

     public MechanicController(MechanicService mechanicService) {
         this.mechanicService = mechanicService;
     }
     @PostMapping
     public Mechanic createMechanic (@RequestBody Mechanic mechanic) {
         return mechanicService.createMechanic(mechanic);
     }
     @GetMapping("/{id}")
     public Mechanic getMechanic (@PathVariable Long id) {
         return mechanicService.getMechanicById(id);
     }
     @GetMapping
     public List<Mechanic>getAllMechanics (){return mechanicService.getAllMechanics();}

     @PutMapping
     public Mechanic updateMechanic(@PathVariable Long id ,@RequestBody Mechanic mechanic) { return mechanicService.updateMechanic(id,mechanic);}

     @DeleteMapping("/{id}")
     public void deleteMechanic(@PathVariable Long id){ mechanicService.deleteMechanic(id);}
}
