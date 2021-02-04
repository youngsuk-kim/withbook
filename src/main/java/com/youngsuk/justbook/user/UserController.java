package com.youngsuk.justbook.user;

import com.youngsuk.justbook.user.dto.UserDto;
import com.youngsuk.justbook.user.dto.UserLoginDto;
import com.youngsuk.justbook.user.dto.UserUpdateDto;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  private UserService userService;

  @Autowired
  public void setUserService(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/register")
  public User register(@RequestBody UserDto userDto) {
    System.out.println(userDto.toString());
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

  @LoginCheck
  @PatchMapping
  public User userInfoUpdate(HttpSession httpSession, @RequestBody UserUpdateDto userUpdateDto) {
    System.out.println(userUpdateDto.getEmail());
    return userService.userInfoUpdate(userUpdateDto);
  }
}
