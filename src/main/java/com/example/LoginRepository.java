package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {

  @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END "
      + "FROM Login u WHERE u.loginId = :loginId and u.password = :pass")
  boolean userExists(@Param("loginId") String loginId, @Param("pass") String pass);
}
