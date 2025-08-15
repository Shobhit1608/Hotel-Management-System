package com.wipro.microservice.hm.bookingservice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class BookingLoggingAspect {

	@Pointcut("execution(* com.wipro.microservice.hm.bookingservice.controllers.BookingController.*(..))")
	public void bookingControllerMethods() {
	}

	@Before("bookingControllerMethods()")
	public void logBefore(JoinPoint joinPoint) {
		log.info("Entering method: {} with arguments: {}", joinPoint.getSignature().getName(), joinPoint.getArgs());
	}

	@After("bookingControllerMethods()")
	public void logAfter(JoinPoint joinPoint) {
		log.info("Exiting method: {}", joinPoint.getSignature().getName());
	}
}
