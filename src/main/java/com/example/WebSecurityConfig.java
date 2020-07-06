package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  public void configure(WebSecurity web) {
    // 認証を必要としないファイル一覧
    web.ignoring().antMatchers("/css/**", "/image/**", "/js/**");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // 認証を必要とするページと必要としないページ
    http.authorizeRequests()
        .antMatchers("/login").permitAll()
        .anyRequest().authenticated();

    // ログインが実行された際の処理の流れ
    http.formLogin().loginPage("/login")
        .loginProcessingUrl("/login")
        .failureUrl("/login?error").defaultSuccessUrl("/messages", false)
        .usernameParameter("id").passwordParameter("pass");
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}

