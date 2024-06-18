package com.lepton.surveybasic.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Aspect
@Slf4j
public class IdLoggingAspect {


    @Pointcut("execution(* com.lepton.surveybasic.id.snowflake.impl.SnowFlakeGeneratorImpl.getSnowflakeId())")
    public void generateSnowflakeIdPointcut() {
    }

    @AfterReturning(pointcut = "generateSnowflakeIdPointcut()", returning = "idMono")
    public void afterReturningSnowflakeId(Mono<Long> idMono) {
        idMono.subscribe(id -> log.info("Generated SnowFlake User Id {}", id));
    }

}
