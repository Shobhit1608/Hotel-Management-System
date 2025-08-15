package com.wipro.microservice.hm.userservices.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

	@Pointcut("execution(* com.wipro.microservice.hm.userservices.controllers.UserController.*(..))")
	public void userControllerMethods() {
	}

	@Before("userControllerMethods()")
	public void logBefore(JoinPoint joinPoint) {
		log.info("Entering method: {} with arguments: {}", joinPoint.getSignature().getName(), joinPoint.getArgs());
	}

	@After("userControllerMethods()")
	public void logAfter(JoinPoint joinPoint) {
		log.warn("Exiting method: {}", joinPoint.getSignature().getName());
	}
}
