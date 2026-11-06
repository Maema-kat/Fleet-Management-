package com.fleetmanagement.backend.controller;

import com.fleetmanagement.backend.dto.AssignmentRequest;
import com.fleetmanagement.backend.dto.AssignmentResponse;
import com.fleetmanagement.backend.dto.AssignmentRequest;
import com.fleetmanagement.backend.service.AssignmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AssignmentResponse createAssignment(@Valid @RequestBody AssignmentRequest request) {
        return AssignmentResponse.from(assignmentService.createAssignment(request));
    }

    @GetMapping
    public List<AssignmentResponse> getAllAssignments() {
        return assignmentService.getAllAssignments().stream()
                .map(AssignmentResponse::from)
                .toList();
    }

    @GetMapping("/{id}")
    public AssignmentResponse getAssignmentById(@PathVariable Long id) {
        return AssignmentResponse.from(assignmentService.getAssignmentById(id));
    }

    @PutMapping("/{id}/end")
    public AssignmentResponse endAssignment(@PathVariable Long id) {
        return AssignmentResponse.from(assignmentService.endAssignment(id));
    }
}