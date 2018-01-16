package anonymous_inner_class_example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
public class SortMain {
    public static void main(String[] args) {

        List<String> strings = Arrays.asList("java", "scala", "groovy", "c++");
        strings.sort((s1, s2) -> s1.length()-s2.length());
        System.out.println(strings);



    }
}
