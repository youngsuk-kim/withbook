package com.youngsuk.justbook.User;

public interface UserRepository {
  User save(User user);

  User findById(Long id);
}
