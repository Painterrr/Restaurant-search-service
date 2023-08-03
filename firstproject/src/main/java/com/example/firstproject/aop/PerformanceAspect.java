package com.example.firstproject.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Slf4j
public class PerformanceAspect {

    // specific annotation target
    @Pointcut("@annotation(com.example.firstproject.annotation.RunningTime)")
    private void enableRunningTime() {}


    // all methods of the basic package
    @Pointcut("execution(* com.example.firstproject..*.*(..))")
    private void cut() {}

    @Around("cut() && enableRunningTime()")
    public void loggingRunningTime(ProceedingJoinPoint joinPoint) throws Throwable {
        // start measurement before method
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // execute target method
        Object returningObj = joinPoint.proceed();

        // after method execution, end measurement and logging
        stopWatch.stop();

        // method name
        String methodName = joinPoint.getSignature()
                .getName();

        log.info("total time of {} => {} sec", methodName, stopWatch.getTotalTimeSeconds());
    }
}
