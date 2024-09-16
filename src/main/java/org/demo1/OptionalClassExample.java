package org.demo1;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class OptionalClassExample {
    public static void main(String[] args) {
        String str="sayed";
        Optional<String> obj = Optional.ofNullable(str);
        Optional<String> obj1 = Optional.empty();
        obj1 = Optional.of("ashutosh");
        System.out.println(obj1);

    }


}
