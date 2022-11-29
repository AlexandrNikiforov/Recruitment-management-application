package com.alexnikiforov.rma.repositories;

import com.alexnikiforov.rma.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
