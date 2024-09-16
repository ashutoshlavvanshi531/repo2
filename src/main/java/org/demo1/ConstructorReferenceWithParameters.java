package org.demo1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " is ";
    }
}

public class ConstructorReferenceWithParameters {
    public static void main(String[] args) {
        Function<String, Person> personCreator = Person::new;
        Person person = personCreator.apply("Alice");
        System.out.println(person); // Output: Alice is 30 years old.


        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<Person> people = names.stream()
                .map(Person::new)
                .toList();

    }
}
