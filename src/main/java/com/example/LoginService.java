package com.example;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

  private final LoginRepository repository;

  public LoginService(LoginRepository repository) {
    this.repository = repository;
  }

  public boolean canLogin(String loginId, String pass) {
    return repository.userExists(loginId, pass);
  }
}
