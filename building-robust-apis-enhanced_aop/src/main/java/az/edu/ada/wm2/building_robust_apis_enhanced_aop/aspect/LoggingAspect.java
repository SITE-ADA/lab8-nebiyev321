
package az.edu.ada.wm2.building_robust_apis_enhanced_aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

//    @Around("@annotation(az.edu.ada.wm2.building_robust_apis_enhanced_aop.annotation.TrackExecutionTime)")
//    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
//        long start = System.currentTimeMillis();
//        Object result = joinPoint.proceed();
//        long time = System.currentTimeMillis() - start;
//        log.info("Execution of {} took {} ms", joinPoint.getSignature(), time);
//        return result;
//    }

    @Pointcut("within(az.edu.ada.wm2.building_robust_apis_enhanced_aop.controller..*)")
    public void controllerLayer() {
    }

    //GlobalExceptionHandler methods can log themselves
    //So better use the logs inside GlobalExceptionHandler
    @Pointcut("within(az.edu.ada.wm2.building_robust_apis_enhanced_aop.exception..*)")
    public void exceptionLayer() {
    }

    @Pointcut("@annotation(az.edu.ada.wm2.building_robust_apis_enhanced_aop.annotation.TrackExecutionTime)")
    public void trackExecutionTimeMethods() {
    }

    @Before("controllerLayer()")
    public void logMethodEntry(JoinPoint joinPoint) {
        log.info(
                "Entered method: {}.{} with arguments: {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs())
        );
    }

    @Before("exceptionLayer()")
    public void logExceptionHandlerEntry(JoinPoint joinPoint) {
        log.info(
                "Entered exception handler: {} with args: {}",
                joinPoint.getSignature().toShortString(),
                Arrays.toString(joinPoint.getArgs())
        );
    }

    @AfterReturning(pointcut = "exceptionLayer()", returning = "result")
    public void logExceptionHandlerExit(JoinPoint joinPoint, Object result) {
        log.info(
                "Exited exception handler: {} with response: {}",
                joinPoint.getSignature().toShortString(),
                result
        );
    }

    @AfterReturning(pointcut = "controllerLayer()", returning = "result")
    public void logMethodExit(JoinPoint joinPoint, Object result) {
        log.info(
                "Exited method: {}.{} with result: {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                result
        );
    }

    @AfterReturning(pointcut = "controllerLayer()")
    public void logVoidMethodExit(JoinPoint joinPoint) {
        log.info(
                "Exited method: {}.{} successfully",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName()
        );
    }

    @AfterThrowing(pointcut = "controllerLayer()", throwing = "ex")
    public void logMethodException(JoinPoint joinPoint, Throwable ex) {
        log.error(
                "Exception in method: {}.{} | message: {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                ex.getMessage(),
                ex
        );
    }

    @Around("trackExecutionTimeMethods()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        try {
            return joinPoint.proceed();
        } finally {
            long time = System.currentTimeMillis() - start;
            log.info("Execution of {} took {} ms",
                    joinPoint.getSignature().toShortString(),
                    time);
        }
    }
}
