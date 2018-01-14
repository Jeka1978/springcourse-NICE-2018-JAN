package test_runner_exmaple;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        TestRunner testRunner = new TestRunner();
        Test1 test1 = new Test1();
        testRunner.runAllTestMethods(test1);
    }
}
