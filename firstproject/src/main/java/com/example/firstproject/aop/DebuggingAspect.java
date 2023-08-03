package com.example.firstproject.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect // add-on injection
@Component // Let the IoC container create and manage those objects.
@Slf4j
public class DebuggingAspect {
    // select target method: all methods in api
    @Pointcut("execution(* com.example.firstproject.api.*.*(..))")
    private void cut() {

    }

    @Before("cut()") // set execution time: it is executed before the target of cut() is executed
    public void loggingArgs(JoinPoint joinPoint) {
        // bring input
        Object[] args = joinPoint.getArgs();

        // class name
        String className = joinPoint.getTarget()
                                    .getClass()
                                    .getSimpleName();

        // method name
        String methodName = joinPoint.getSignature()
                                    .getName();

        // logging input
        for (Object obj : args) {
            log.info("input of {}#{} => {}", className, methodName, obj);
        }
    }

    @AfterReturning(value = "cut()", returning = "returnObj")
    public void loggingReturnValue(JoinPoint joinPoint,
                                   Object returnObj) {
        // class name
        String className = joinPoint.getTarget()
                .getClass()
                .getSimpleName();

        // method name
        String methodName = joinPoint.getSignature()
                .getName();

        // logging Return
        // return of CommentService#create() => CommentDto(id=10. ...)
        log.info("return of {}#{} => {}", className, methodName, returnObj);
    }
}
