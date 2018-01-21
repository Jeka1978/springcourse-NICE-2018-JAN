package my_spring.spring_aop_example;

import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author Evgeny Borisov
 */
@Aspect
public class BenchmarkAspect {

    @Before("@annotation(my_spring.Benchmark)")
    @SneakyThrows
    public Object handleBenchmarkMethods(ProceedingJoinPoint jp) {
        System.out.println("*********benchmark start for method "+jp.getSignature().getName()+" ************");
        long start = System.nanoTime();
        Object retVal = jp.proceed();
        long end = System.nanoTime();
        System.out.println(end-start);
        System.out.println("*********benchmark end for method "+jp.getSignature().getName()+" ************");
        return retVal;
    }
}
