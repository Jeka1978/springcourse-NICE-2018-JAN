package my_spring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Evgeny Borisov
 */
public class BenchmarkProxyConfigurator implements ProxyConfigurator {
    @Override
    public Object configureProxy(Object t, Class type) {
        if (type.isAnnotationPresent(Benchmark.class)) {
            return Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("*********benchmark start for method " + method.getName() + " ************");
                    long start = System.nanoTime();
                    Object retVal = method.invoke(t, args);
                    long end = System.nanoTime();
                    System.out.println(end - start);
                    System.out.println("*********benchmark end for method " + method.getName() + " ************");
                    return retVal;

                }
            });
        } else {
            return t;
        }
    }
}
