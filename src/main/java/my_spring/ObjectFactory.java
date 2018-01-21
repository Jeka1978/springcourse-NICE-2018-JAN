package my_spring;

import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

import javax.annotation.PostConstruct;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig();
    private Reflections scanner = new Reflections("my_spring");
    private List<ObjectConfigurator> objectConfigurators = new ArrayList<>();
    private List<ProxyConfigurator> proxyConfigurators = new ArrayList<>();

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    @SneakyThrows
    private ObjectFactory() {
        Set<Class<? extends ObjectConfigurator>> classes = scanner.getSubTypesOf(ObjectConfigurator.class);
        for (Class<? extends ObjectConfigurator> aClass : classes) {
            if (!Modifier.isAbstract(aClass.getModifiers())) {
                objectConfigurators.add(aClass.newInstance());
            }
        }
        Set<Class<? extends ProxyConfigurator>> set = scanner.getSubTypesOf(ProxyConfigurator.class);
        for (Class<? extends ProxyConfigurator> aClass : set) {
            if (!Modifier.isAbstract(aClass.getModifiers())) {
                proxyConfigurators.add(aClass.newInstance());
            }
        }
    }




    @SneakyThrows
    public <T> T createObject(Class<T> type)  {
        type = resolveImpl(type);
        T t = type.newInstance();
        configure(t);
        invokeInitMethod(type, t);

        t = wrapWithProxy(type, t);


        return t;

    }






    private <T> T wrapWithProxy(Class<T> type, T t) {
        for (ProxyConfigurator proxyConfigurator : proxyConfigurators) {
            t = (T) proxyConfigurator.configureProxy(t, type);
        }
        return t;
    }

    private <T> void invokeInitMethod(Class<T> type, T t) throws IllegalAccessException, InvocationTargetException {
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(t);
            }
        }
    }

    private <T> Class<T> resolveImpl(Class<T> type) {
        if (type.isInterface()) {
            Class<T> implClass = config.getImplClass(type);
            if (implClass == null) {
                Set<Class<? extends T>> classes = scanner.getSubTypesOf(type);
                if (classes.size() != 1) {
                    throw new RuntimeException("you have 0 or more than 1 impl of " + type + " please update your config");
                }
                implClass = (Class<T>) classes.iterator().next();
            }
            type = implClass;

        }
        return type;
    }

    private <T> void configure(T t) {
        for (ObjectConfigurator objectConfigurator : objectConfigurators) {
            objectConfigurator.configure(t);
        }
    }


}
