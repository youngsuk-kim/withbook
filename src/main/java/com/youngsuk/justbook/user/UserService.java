package com.youngsuk.justbook.user;

import com.youngsuk.justbook.domain.User;
import com.youngsuk.justbook.user.dto.UserDto;
import com.youngsuk.justbook.user.dto.UserLoginDto;
import com.youngsuk.justbook.user.dto.UserUpdateDto;
import java.util.Optional;
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

  public boolean login(UserLoginDto userLoginDto) {
    Optional<User> user = userRepository.findById(userLoginDto.getId());
    boolean isLoginSuccess =
        passwordEncoder.matches(userLoginDto.getPassword(), user.orElse(null).getPassword());

    if (!isLoginSuccess) {
      throw new BadCredentialsException("비밀번호가 일치하지 않습니다");
    } else {
      return true;
    }
  }

  public User userInfoUpdate(UserUpdateDto userUpdateDto) {
    User user =
        userRepository
            .findById(userUpdateDto.getId())
            .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + userUpdateDto.getId()));
    user.update(
        userUpdateDto.getEmail(),
        userUpdateDto.getPhoneNumber(),
        userUpdateDto.getAddress());

    userRepository.save(user);
    return user;
  }
}
