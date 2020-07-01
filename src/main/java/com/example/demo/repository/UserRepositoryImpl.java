package com.example.demo.repository;


import java.util.Map;
import java.util.Optional;

import com.example.demo.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class UserRepositoryImpl implements UserRepository{

  @Autowired
  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }
  
  @Override
  public Optional<User> findOne(int id) {
    
    String sql = "SELECT user.id, name, pass, introduce, user_image FROM user "
      + "WHERE id = ?";
      
    Map<String, Object> result = jdbcTemplate.queryForMap(sql, id);

      User user = new User();
      user.setId((int)result.get("id"));
      user.setName((String)result.get("user"));
      user.setPass((String)result.get("pass"));
      user.setIntroduce((String)result.get("introduce"));
      user.setUserImage((MultipartFile)result.get("user_image"));
      System.out.println(result);
      //bookをOptionalでラップする
      Optional<User> userOpt = Optional.ofNullable(user);
      return userOpt;
    }

    @Override
    public void save(User user) {
      jdbcTemplate.update("INSERT INTO user(name, pass, introduce, user_image) VALUES(?, ?, ?, ?)",
      user.getName(), user.getPass(), user.getIntroduce(), user.getUserImage() );
    }
    
    @Override
    public int update(User user) {
      return   jdbcTemplate.update("UPDATE user SET name = ?, pass = ?, introduce = ?, user_image = ? WHERE id = ?",
      user.getName(), user.getPass(), user.getIntroduce(), user.getUserImage() );
    }

    @Override
    public int delete(int id) {
      return jdbcTemplate.update("DELETE FROM book WHERE id = ?", id);
    }

}