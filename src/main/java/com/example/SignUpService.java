package com.example;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SignUpService {

  private final UsersRepository repository;

  private final PasswordEncoder passwordEncoder;

  SignUpService(UsersRepository repository, PasswordEncoder passwordEncoder) {
    this.repository = repository;
    this.passwordEncoder = passwordEncoder;
  }

  /**
   * 新規にユーザーを作成する。
   *
   * @param loginId ログインID
   * @param pass パスワード
   */
  @Transactional
  public void createUser(String loginId, String pass) {
    Users user = Users.builder()
        .loginId(loginId)
        .password(passwordEncoder.encode(pass))
        .build();
    repository.save(user);
  }
}
