package immutable;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        StringBuilder sentence = new StringBuilder("java" + " " + " is  " + " best ");

        for (String arg : args) {
            sentence.append(arg);
        }
        String s = sentence.toString();
        System.out.println("sentence = " + s);
    }
}
