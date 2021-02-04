package com.youngsuk.justbook.user;

import com.youngsuk.justbook.exception.LoginException;
import com.youngsuk.justbook.user.dto.UserUpdateDto;
import javax.servlet.http.HttpSession;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoginCheckAspect {
  @Around("@annotation(LoginCheck)")
  public void loginCheck(ProceedingJoinPoint joinPoint) throws Throwable {
    HttpSession httpSession = (HttpSession) joinPoint.getArgs()[0];
    UserUpdateDto userUpdateDto = (UserUpdateDto) joinPoint.getArgs()[1];

    if (httpSession.getAttribute("user") == null
        || !httpSession.getAttribute("user").equals(userUpdateDto.getEmail())) {
      throw new LoginException();
    } else {
      joinPoint.proceed();
    }
  }
}
