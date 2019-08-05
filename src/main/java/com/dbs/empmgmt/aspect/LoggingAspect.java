package com.dbs.empmgmt.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@EnableAspectJAutoProxy
@Component
@Aspect
public class LoggingAspect {
	
	@Before("within(com.dbs.empmgmt.*.*)")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("Before executing the method :: ");
		Arrays.asList(joinPoint.getArgs()).forEach(System.out::println);
	}
	
	@After("within(com.dbs.empmgmt.*.*)")
	public void logAfter() {
		System.out.println("After executing the method :: ");
	}

}
