package com.alexnikiforov.rma.services;

import com.alexnikiforov.rma.domain.Role;
import com.alexnikiforov.rma.domain.User;
import com.alexnikiforov.rma.dto.UserRequestDto;
import com.alexnikiforov.rma.dto.UserResponseDto;
import com.alexnikiforov.rma.exception.CompanyException;
import com.alexnikiforov.rma.exception.UserException;
import com.alexnikiforov.rma.repositories.RoleRepository;
import com.alexnikiforov.rma.repositories.UserRepository;
import com.alexnikiforov.rma.util.DtoUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    /*public UserResponseDto addUser(UserRequestDto userRequestDto) {
        log.info("Add user: {}", userRequestDto);

        try {
            User user = DtoUtil.toUserEntity(userRequestDto);
            user.setEnabled(true);
            Role role = roleRepository.findByName("ROLE_USER");
            user.addRole(role);
            role.
            return Optional.of(userRepository.save(user))
                    .map(DtoUtil::toUserResponseDto)
                    .orElseThrow(() -> new UserException("Error while adding a new user"));
        } catch (Exception e) {
            log.error("Error while adding user: {}", userRequestDto);
            throw new UserException("Error while adding a user", e);
        }
    }*/


}
