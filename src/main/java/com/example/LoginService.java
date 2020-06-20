package com.example;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

  private final UsersRepository repository;

  public LoginService(UsersRepository repository) {
    this.repository = repository;
  }

  public boolean canLogin(String loginId, String pass) {
    return repository.userExists(loginId, pass);
  }
}
