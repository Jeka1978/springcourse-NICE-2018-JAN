package io;

import lombok.SneakyThrows;

import java.io.*;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
public class MainForRead {

    @SneakyThrows
    public static void main(String[] args) throws IOException {

        System.out.println(Math.sqrt(4));
        File file = new File("C:\\temp\\data.obj");

        FileInputStream fos = new FileInputStream(file);
        ObjectInputStream oos = new ObjectInputStream(fos);
        List<Employee> employeees = (List<Employee>) oos.readObject();
        System.out.println(employeees.size());
        employeees.forEach(System.out::println);

    }
}





