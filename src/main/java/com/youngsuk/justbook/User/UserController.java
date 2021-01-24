package com.youngsuk.justbook.User;

import com.youngsuk.justbook.User.Dto.UserDto;
import com.youngsuk.justbook.User.Dto.UserLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

  @GetMapping()
  public User getUserData(@RequestBody UserDto userDto) {
    return userService.register(userDto);
  }

  @PostMapping()
  public void getUserLoginData(@RequestBody UserLoginDto userLoginDto) {
    userService.login(userLoginDto);
  }
}
