package org.demo1;

public class SingletonPattern {

    private static SingletonPattern obj;

    private SingletonPattern() {
    }

    public static SingletonPattern getObject() {

        synchronized (SingletonPattern.class) {
            if (obj == null) {
                obj = new SingletonPattern();
            }

        }
        return obj;
    }
}