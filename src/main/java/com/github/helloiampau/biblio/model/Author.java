package com.github.helloiampau.biblio.model;

import javax.persistence.*;
import java.util.Set;

/**
 * biblio
 * Created by Pasquale Boemio <boemianrapsodi@gmail.com>
 * <p/>
 * 19 October 2014.
 */
@Entity
public class Author extends JsonObject {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  @Column(nullable=false)
  private Long id;
  @Column(nullable=false)
  private String name;
  @Column(nullable=false)
  private String surname;
  @OneToMany(mappedBy="author")
  private Set<Book> books;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }
}
