package anonymous_inner_class_example;

import java.util.Arrays;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
public class Main2 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("java", "scala", "groovy", "c++");

        ListUtil.forEachWithDelay(strings, 500, System.out::println);
    }
}
