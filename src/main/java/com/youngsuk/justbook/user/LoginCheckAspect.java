package com.youngsuk.justbook.user;

import com.youngsuk.justbook.exception.LoginException;
import javax.servlet.http.HttpSession;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoginCheckAspect {
  @Around("@annotation(LoginCheck)")
  public void loginCheck(ProceedingJoinPoint joinPoint) {
    HttpSession httpSession = (HttpSession) joinPoint.getArgs()[0];
    if (httpSession.getAttribute("user") == null) {
      throw new LoginException();
    }
  }
}
