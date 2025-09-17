package com.example.gestaotech.controller;

import com.example.gestaotech.domain.usuario.AuthenticationDTO;
import com.example.gestaotech.domain.usuario.LoginResponseDTO;
import com.example.gestaotech.domain.usuario.RegisterDTO;
import com.example.gestaotech.domain.usuario.User;
import com.example.gestaotech.infra.security.TokenService;
import com.example.gestaotech.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;
    //Para fazer o login de um usuário (email e senha)
    @PostMapping("/login")
    public ResponseEntity login (@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.emUser(), data.snUser());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));

    }

    //Para fazer o cadastro de um usuário (todas as informações)
    @PostMapping("/cadastrar")
    public ResponseEntity cadastrar (@RequestBody @Valid RegisterDTO data){
        if (this.userRepository.FindByEmUser(data.emUser()) != null)
            return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.snUser());
        User newUser = new User(data.nmUser(), data.emUser(), data.cpfUser(), encryptedPassword, data.roleUser());

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }


}
