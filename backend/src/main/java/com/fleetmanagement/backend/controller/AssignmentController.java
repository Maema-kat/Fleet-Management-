package com.fleetmanagement.backend.controller;

import com.fleetmanagement.backend.entity.AssignmentEntity;
import com.fleetmanagement.backend.service.AssignmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/assignments")
public class AssignmentController
{
    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService){this.assignmentService = assignmentService;}

    @PostMapping
    public AssignmentEntity createAssignment(@RequestBody AssignmentEntity assignment) {
        return assignmentService.createAssignment(assignment);
    }
    @GetMapping
    public List<AssignmentEntity> getAllAssignments(){
        return assignmentService.getAllAssignments();
    }
    @GetMapping("/{id}")
    public AssignmentEntity getAssignmentById(@PathVariable Long id) {
        return assignmentService.getAssignmentById(id);
    }
    @PutMapping("/{id}")
    public AssignmentEntity updateAssignment(@PathVariable Long id ,@RequestBody AssignmentEntity assignment) {
        return assignmentService.updateAssignment(id,assignment);
    }
    @DeleteMapping("/{id}")
    public void deleteAssignment(@PathVariable Long id ) {
        assignmentService.deleteAssignment(id);
    }

}
