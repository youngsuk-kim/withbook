package com.youngsuk.justbook.user;

public interface UserRepository {
  User save(User user);

  User findById(Long id);
}
