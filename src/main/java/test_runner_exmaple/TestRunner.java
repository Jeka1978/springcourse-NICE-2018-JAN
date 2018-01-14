package test_runner_exmaple;

import lombok.SneakyThrows;

import java.lang.reflect.Method;

/**
 * @author Evgeny Borisov
 */
public class TestRunner {
    @SneakyThrows
    public void runAllTestMethods(Object o) {
        Class<?> type = o.getClass();
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("test")) {
                method.invoke(o);
            }
        }
    }
}
