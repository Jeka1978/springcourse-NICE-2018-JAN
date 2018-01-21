package my_spring;

import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;
import java.util.Set;

/**
 * @author Evgeny Borisov
 */
public class InjectRandomIntObjectConfigurator implements ObjectConfigurator {
    @Override
    @SneakyThrows
    public void configure(Object t) {

        Class<?> type = t.getClass();
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

    }
}
