package anonymous_inner_class_example;

/**
 * @author Evgeny Borisov
 */
@FunctionalInterface
public interface Action<T> {
    void perform(T t);

}
