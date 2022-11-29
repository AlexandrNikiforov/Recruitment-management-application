package com.alexnikiforov.rma.bootstrap;

import com.alexnikiforov.rma.domain.Role;
import com.alexnikiforov.rma.repositories.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class DatabaseLoader implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) {
        Role userRole = new Role("ROLE_USER");
//        roleRepository.save(userRole);
        Role adminRole = new Role("ROLE_ADMIN");
//        roleRepository.save(adminRole);
    }


}
