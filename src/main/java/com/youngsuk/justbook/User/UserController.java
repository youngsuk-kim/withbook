package com.youngsuk.justbook.User;

import com.youngsuk.justbook.User.Dto.UserDto;
import com.youngsuk.justbook.User.Dto.UserLoginDto;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  UserService userService;

  @Autowired
  public void setUserService(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/register")
  public User register(@RequestBody UserDto userDto) {
    return userService.register(userDto);
  }

  @PostMapping("/login")
  public boolean login(HttpSession httpSession, @RequestBody UserLoginDto userLoginDto) {
    boolean isLoginSuccess;

    isLoginSuccess = userService.login(userLoginDto);
    if (isLoginSuccess) {
      httpSession.setAttribute("user", userLoginDto.getEmail());
    }
    return isLoginSuccess;
  }
}
