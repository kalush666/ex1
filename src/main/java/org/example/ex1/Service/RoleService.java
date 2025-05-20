package org.example.ex1.Service;

import org.example.ex1.Entity.Role;
import org.example.ex1.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private final RoleRepository repository;

    @Autowired
    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public Role getRoleById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
