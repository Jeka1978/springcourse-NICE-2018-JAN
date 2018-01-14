package io;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
public class MainForWrite {

    public static void main(String[] args) throws IOException {
        Employee employee = Employee.builder().age(18).name("Sara").build();

        File file = new File("C:\\temp\\data.obj");
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        List<Employee> employees = Arrays.asList(employee, employee, employee);
        oos.writeObject(employees);

    }
}





