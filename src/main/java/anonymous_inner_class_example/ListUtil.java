package anonymous_inner_class_example;

import lombok.SneakyThrows;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public class ListUtil {
    @SneakyThrows
    public static <T> void forEachWithDelay(List<T> list, int delay, Action<T> action) {
        for (T t : list) {
            Thread.sleep(delay);
            action.perform(t);
        }
    }
}
