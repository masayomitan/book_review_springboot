package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
      //ログインページを指定。
      //ログインページへのアクセスは全員許可する。
      http.formLogin()
          .loginPage("/login")
          .loginProcessingUrl("/authenticate")
          .usernameParameter("username")
          .passwordParameter("pass")
          .defaultSuccessUrl("/")
          .permitAll();

      //会員登録機能実装時に追加
      http.authorizeRequests()
          .antMatchers("/RegistrationForm").permitAll()
          .antMatchers("/Register").permitAll()
          .antMatchers("/Result").permitAll()
          .anyRequest().authenticated();
  }

  @Bean
  PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
  }
}
