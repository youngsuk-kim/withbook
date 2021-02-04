package com.youngsuk.justbook.exception;

public class LoginException extends RuntimeException{

  public LoginException() {
    super("로그인을 다시 해주세요");
  }
}
