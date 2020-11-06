package ir.rezacolonel.springTutorial1.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    private static Log LOGGER = LogFactory.getLog("METHOD_LOGGER");

    @Pointcut("execution(public * ir.rezacolonel.springTutorial1.service.*.*(..))")
    public void allMethodsInCalculation() {
    }

    @Around("allMethodsInCalculation()&&@annotation(ir.rezacolonel.springTutorial1.aop.Log)")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.info(String.format(
                "Method %s is going to Call from class %s",
                joinPoint.getSignature().toString(),
                joinPoint.getTarget().getClass().getSimpleName()));

        Object returnObj = joinPoint.proceed(joinPoint.getArgs());

        LOGGER.info(String.format(
                "Method %s has called from class %s with return value type %s",
                joinPoint.getSignature().toString(),
                joinPoint.getTarget().getClass().getSimpleName(),
                returnObj.getClass().getName()));
        return returnObj;
    }
}
