package com.fleetmanagement.backend.service;
import org.springframework.stereotype.Service;
import com.fleetmanagement.backend.repository.RoleRepository;
import com.fleetmanagement.backend.entity.Role;
import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
    public Role getRoleById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));
    }
    public Role updateRole(Long id, Role updatedRole) {

        Role existingRole = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        existingRole.setName(updatedRole.getName());

        return roleRepository.save(existingRole);
    }
    public void deleteRole(Long id) {

        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        roleRepository.delete(role);
    }



}
