package com.youngsuk.justbook.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@Entity // This tells Hibernate to make a table out of this class
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "USER_ID")
  private Long id;

  @Column(name = "EMAIL")
  private String email;

  @Column(name = "PASSWORD")
  private String password;

  @Column(name = "PHONE_NUMBER")
  private String phoneNumber;

  @Column(name = "ADDRESS")
  private String address;

  public void update(String email, String phoneNumber, String address) {
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.address = address;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getAddress() {
    return address;
  }

  public String getPassword() {
    return password;
  }

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }
}
