package com.example;

import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService {

  private final UsersRepository repository;

  public LoginService(UsersRepository repository) {
    this.repository = repository;
  }

  public boolean canLogin(String loginId, String pass) {
    return repository.userExists(loginId, pass);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    if (username == null) {
      throw new UsernameNotFoundException("username not found");
    }

    Users user = repository.findByLoginId(username);
    return Optional.ofNullable(user).orElseThrow(() -> new UsernameNotFoundException("user not found"));
  }
}
