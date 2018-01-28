package aop_lab;

import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Aspect
@Component
public class ExceptionHandlerAspect {
    @Value("${dbaMails}")
    private String[] mails;



    @Pointcut("execution(* aop_lab.dao..*.*(..))")
    public void allDaosMethods(){}


    @Pointcut("execution(* aop_lab..*.*(..))")
    public void allBusinessMethods(){}

    @Around("allDaosMethods()")
    @SneakyThrows
    public Object handleDBEceptions(ProceedingJoinPoint pjp) {
        Object retVal=null;
        try {
            retVal = pjp.proceed();
        } catch (DataBaseException ex) {
            for (String mail : mails) {
                System.out.println("sending to "+mail+" "+ex.getMessage());
            }
            throw ex;
        }

        return retVal;
    }












}
