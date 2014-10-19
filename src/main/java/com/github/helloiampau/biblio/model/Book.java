package com.github.helloiampau.biblio.model;

import javax.persistence.*;

/**
 * biblio
 * Created by Pasquale Boemio <boemianrapsodi@gmail.com>
 * <p/>
 * 13 October 2014.
 */
@Entity
public class Book extends JsonObject {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  @Column(nullable=false)
  private Long id;
  @Column(nullable=false)
  private String title;
  @Column(nullable=false)
  private Integer amount;
  @OneToOne
  @JoinColumn(nullable=false)
  private Author author;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
