package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class User  {

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  @Column(name="name")
  private String name;
  @Column(name="pass")
  private String pass;
  @Column(name="introduce")
  private String introduce;
  @Column(name="user_image")
  private Byte[] userImage;

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getIntroduce() {
      return introduce;
    }
  
    public void setIntroduce(String introduce) {
      this.introduce = introduce;
    }

    public Byte[] getUserImage() {
      return userImage;
    }
  
    public void setUserImage(Byte[] userImage) {
      this.userImage = userImage;
    }

}