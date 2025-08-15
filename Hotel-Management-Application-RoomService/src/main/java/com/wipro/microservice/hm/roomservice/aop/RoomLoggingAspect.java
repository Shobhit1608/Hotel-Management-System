package com.wipro.microservice.hm.roomservice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class RoomLoggingAspect {

    @Pointcut("execution(* com.wipro.microservice.hm.roomservice.controllers.RoomController.*(..))")
    public void roomControllerMethods() {}

	@Before("roomControllerMethods()")
	public void logBefore(JoinPoint joinPoint) {
		log.info("Entering method: {} with arguments: {}", joinPoint.getSignature().getName(), joinPoint.getArgs());
	}

	@After("roomControllerMethods()")
	public void logAfter(JoinPoint joinPoint) {
		log.info("Exiting method: {}", joinPoint.getSignature().getName());
	}
}
