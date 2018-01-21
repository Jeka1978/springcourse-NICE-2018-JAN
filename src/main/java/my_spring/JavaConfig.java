package my_spring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Evgeny Borisov
 */
public class JavaConfig implements Config {

    private Map<Class, Class> map = new HashMap<>();


    public JavaConfig() {
        map.put(Speaker.class, ConsoleSpeaker.class);
        map.put(Cleaner.class, CleanerImpl.class);

    }

    @Override
    public <T> Class<T> getImplClass(Class<T> type) {

        return map.get(type);
    }
}
