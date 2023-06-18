package com.example.demo.GestionConge.security.auth;


import com.example.demo.GestionConge.controller.CompteCongeController;
import com.example.demo.GestionConge.model.dto.CompteCongeDto;
import com.example.demo.GestionConge.model.entity.Employee;
import com.example.demo.GestionConge.model.entity.Role;
import com.example.demo.GestionConge.repository.EmployeeRepo;
import com.example.demo.GestionConge.security.filters.JwtService;
import com.example.demo.GestionConge.security.token.Token;
import com.example.demo.GestionConge.security.token.TokenRepository;
import com.example.demo.GestionConge.security.token.TokenType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  
  private final EmployeeRepo repository;
  private final TokenRepository tokenRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;


  private final CompteCongeController compteCongeController;
  private final AuthenticationManager authenticationManager;


  public AuthenticationResponse register(RegisterRequest request) {
      var user = Employee.builder()
        .matricule(request.getMatricule())
        .phone_number(request.getPhone_number())
        .firstname(request.getFirstname())
        .lastname(request.getLastname())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .NNI(request.getNNI())
        .role(request.getRole())
        .demandeConges(request.getDemandeConges())
        .poste(request.getPoste())
        .compteConge(request.getCompteConge())

        .build();
    var savedUser = repository.save(user);
    var jwtToken = jwtService.generateToken(user);

     // create account for the newly registered customer
     //accountController.createAccount(savedUser.getId(), 0, "Active");
      compteCongeController.SaveCompteConge(new CompteCongeDto(null,24,new Date(),savedUser));
    saveUserToken(savedUser, jwtToken);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
        )
    );
    var user = repository.findByEmail(request.getEmail())
        .orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    revokeAllUserTokens(user);
    saveUserToken(user, jwtToken);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }

  private void saveUserToken(Employee user, String jwtToken) {
    var token = Token.builder()
        .user(user)
        .token(jwtToken)
        .tokenType(TokenType.BEARER)
        .expired(false)
        .revoked(false)
        .build();
    tokenRepository.save(token);
  }

  private void revokeAllUserTokens(Employee user) {
    var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
    if (validUserTokens.isEmpty())
      return;
    validUserTokens.forEach(token -> {
      token.setExpired(true);
      token.setRevoked(true);
    });
    tokenRepository.saveAll(validUserTokens);
  }
}

