package com.alexnikiforov.rma.controller;

import com.alexnikiforov.rma.dto.UserRequestDto;
import com.alexnikiforov.rma.dto.UserResponseDto;
import com.alexnikiforov.rma.dto.VacancyRequestDto;
import com.alexnikiforov.rma.dto.VacancyResponseDto;
import com.alexnikiforov.rma.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    /*@PostMapping
    public ResponseEntity<UserResponseDto> addUser(@RequestBody UserRequestDto userRequestDto) {
        //TODO add validation
        UserResponseDto user = userService.addUser(userRequestDto);
        return ResponseEntity.ok().body(user);
    }*/

}
