package com.alexnikiforov.rma.repositories;

import com.alexnikiforov.rma.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
