package com.example.demo.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;





//@RepositoryはSpring MVCでデータ層のクラス（DAO等のDBアクセスを行うクラス）に付与する。
@Repository
public class BookDaoImpl {
  
  private final JdbcTemplate jdbcTemplate;
}