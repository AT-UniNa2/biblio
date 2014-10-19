package com.github.helloiampau.biblio.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;

/**
 * biblio
 * Created by Pasquale Boemio <boemianrapsodi@gmail.com>
 * <p/>
 * 16 October 2014.
 */
public class User extends JsonObject {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;
  private String username;
  private String password;

  public User() {}

  public User(HttpServletRequest request) throws Exception {
    this.username = this.validate(String.class, request.getParameter("username"));
    this.password = this.validate(String.class, request.getParameter("password"));
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
