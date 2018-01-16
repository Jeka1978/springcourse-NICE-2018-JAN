package my_spring;

import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.util.Random;
import java.util.Set;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig();
    private Reflections scanner = new Reflections("my_spring");

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    private ObjectFactory() {
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
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
        T t = type.newInstance();

        Set<Field> fields = ReflectionUtils.getAllFields(type);
        for (Field field : fields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                Random random = new Random();
                int value = min + random.nextInt(max - min)+1;
                field.setAccessible(true);
                field.set(t,value);
            }
        }

        return t;

    }


}
