package com.collect.fond.configuration.logger;

import com.collect.fond.security.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LogAspect {
    public static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Before("@annotation(com.collect.fond.configuration.logger.Logged)")
    public void startAProcess(JoinPoint joinPoint) throws Throwable {
        logger.info(SecurityUtils.lireLoginUtilisateurConnecte() + " - " + joinPoint.getSignature().getName() +  " - " + Arrays.toString(joinPoint.getArgs()));
    }
}
