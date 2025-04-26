package br.com.fiap.contacts.controller;

import br.com.fiap.contacts.dto.LoginDto;
import br.com.fiap.contacts.dto.UserOutputDto;
import br.com.fiap.contacts.dto.UserRegisterDto;
import br.com.fiap.contacts.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService service;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginDto userDto) {
        UsernamePasswordAuthenticationToken userPassword =
                new UsernamePasswordAuthenticationToken(
                        userDto.email(),
                        userDto.password()
                );
        Authentication auth = authenticationManager.authenticate(userPassword);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserOutputDto create(@RequestBody @Valid UserRegisterDto userDto) {
        UserOutputDto userRegister = null;
        userRegister = service.create(userDto);
        return userRegister;
    }
}
