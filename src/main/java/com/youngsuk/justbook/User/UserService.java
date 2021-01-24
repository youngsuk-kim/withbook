package com.youngsuk.justbook.User;

import com.youngsuk.justbook.User.Dto.UserDto;
import com.youngsuk.justbook.User.Dto.UserLoginDto;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public UserService(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  @Autowired
  public void setUserRepository(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Transactional
  public User register(UserDto userDto) {
    User user =
        User.builder()
            .email(userDto.getEmail())
            .password(passwordEncoder.encode(userDto.getPassword()))
            .phoneNumber(userDto.getPhoneNumber())
            .address(userDto.getAddress())
            .build();

    return userRepository.save(user);
  }

  public void login(UserLoginDto userLoginDto) {
    User user = userRepository.findById(userLoginDto.getId());
    boolean isLoginSuccess = passwordEncoder.matches(userLoginDto.getPassword(), user.getPassword());

    if (!isLoginSuccess) {
      throw new BadCredentialsException("비밀번호가 일치하지 않습니다");
    }
  }
}
