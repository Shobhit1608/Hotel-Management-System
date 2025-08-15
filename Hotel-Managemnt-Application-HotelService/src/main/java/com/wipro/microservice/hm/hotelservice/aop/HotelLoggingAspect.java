package com.wipro.microservice.hm.hotelservice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class HotelLoggingAspect {

    @Pointcut("execution(* com.wipro.microservice.hm.hotelservice.controllers.HotelController.*(..))")
    public void hotelControllerMethods() {}

    @Before("hotelControllerMethods()")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Entering method: {} with arguments: {}", 
                 joinPoint.getSignature().getName(),
                 joinPoint.getArgs());
    }

    @After("hotelControllerMethods()")
    public void logAfter(JoinPoint joinPoint) {
        log.info("Exiting method: {}", 
                 joinPoint.getSignature().getName());
    }
}
