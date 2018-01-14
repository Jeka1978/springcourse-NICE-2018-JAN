package com.nice.msr;

import java.util.Arrays;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
public class Main {

    private String helloMyFriend;

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 2, 3);

        integers.forEach(System.out::println);

        for (Integer integer : integers) {
            System.out.println("integer = " + integer);
        }

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            System.out.println("arg" + i + " = " + arg);

        }
        for (String arg : args) {
            System.out.println("arg = " + arg);
        }
        System.out.println("Hello NICE!!!");
    }
}
