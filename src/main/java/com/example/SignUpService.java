package com.example;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SignUpService {

  private final UsersRepository repository;

  SignUpService(UsersRepository repository) {
    this.repository = repository;
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
        .password(pass)
        .build();
    repository.save(user);
  }
}
