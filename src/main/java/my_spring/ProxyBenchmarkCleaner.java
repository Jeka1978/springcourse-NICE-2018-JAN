package my_spring;

/**
 * @author Evgeny Borisov
 */
public class ProxyBenchmarkCleaner extends CleanerImpl {


    @Override
    public void clean() {
        long start = System.nanoTime();
        super.clean();
        long end = System.nanoTime();
        System.out.println(end-start);
    }
}
