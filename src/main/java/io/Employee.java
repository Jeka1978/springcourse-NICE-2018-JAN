package io;

import lombok.*;

import java.io.Serializable;

/**
 * @author Evgeny Borisov
 */
@Data
@AllArgsConstructor
@Builder
public class Employee implements Serializable{
    private String name;
    private transient int age;
}
