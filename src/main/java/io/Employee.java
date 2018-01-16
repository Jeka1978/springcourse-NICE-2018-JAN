package io;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Data
@AllArgsConstructor
@Builder
public class Employee implements Serializable{
    private String name;
    private transient int age;
    private ArrayList<String> childrenNames = new ArrayList<>();
}
