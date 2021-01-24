package com.youngsuk.justbook.User;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryJpa implements UserRepository {

  private EntityManager em;

  @Autowired
  public void setEm(EntityManager em) {
    this.em = em;
  }

  @Override
  public User save(User user) {
    em.persist(user);
    return user;
  }

  @Override
  public User findById(Long id) {
    return em.find(User.class, id);
  }
}
