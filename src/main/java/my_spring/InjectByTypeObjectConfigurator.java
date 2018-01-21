package my_spring;

import lombok.SneakyThrows;

import java.lang.reflect.Field;

/**
 * @author Evgeny Borisov
 */
public class InjectByTypeObjectConfigurator implements ObjectConfigurator {
    @Override
    @SneakyThrows
    public void configure(Object t) {
        Class<?> type = t.getClass();
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                Class<?> typeToInject = field.getType();
                Object object = ObjectFactory.getInstance().createObject(typeToInject);
                field.setAccessible(true);
                field.set(t,object);
            }
        }
    }
}
