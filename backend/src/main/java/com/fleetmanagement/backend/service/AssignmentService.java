package com.fleetmanagement.backend.service;

import com.fleetmanagement.backend.entity.AssignmentEntity;
import com.fleetmanagement.backend.repository.Assignment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService {
    private final Assignment assignmentRepository;

    public AssignmentService(Assignment assignmentRepository) {this.assignmentRepository =assignmentRepository;}

    public AssignmentEntity createAssignment(AssignmentEntity assignment){
        return assignmentRepository.save(assignment);
    }
    public List<AssignmentEntity> getAllAssignments () {
        return assignmentRepository.findAll();
    }
    public AssignmentEntity getAssignmentById(Long id) {
        return assignmentRepository.findById(id).orElseThrow(()-> new RuntimeException("assignment not found"));
    }
    public AssignmentEntity updateAssignment(Long id ,AssignmentEntity updatedassignment) {
        AssignmentEntity existingAssignment = assignmentRepository.findById(id).orElseThrow(()-> new RuntimeException("assignment not found"));

        existingAssignment.setDriver(updatedassignment.getDriver());
        existingAssignment.setStartDate(updatedassignment.getStartDate());
        existingAssignment.setEndDate(updatedassignment.getEndDate());
        existingAssignment.setStatus(updatedassignment.getStatus());

        return assignmentRepository.save(existingAssignment);

    }
    public void deleteAssignment(Long id) {
        AssignmentEntity assignmentR=assignmentRepository.findById(id).orElseThrow(()-> new RuntimeException("assignment not found"));
        assignmentRepository.delete(assignmentR);
    }

}
