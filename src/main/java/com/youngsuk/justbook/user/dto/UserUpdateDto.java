package com.youngsuk.justbook.user.dto;

public class UserUpdateDto {
  private Long id;
  private String email;
  private String phoneNumber;
  private String address;

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getAddress() {
    return address;
  }
}
