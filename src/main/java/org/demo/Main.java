package org.demo;

import org.demo1.LinkedList;
import org.demo1.SingletonPattern;

import java.io.LineNumberReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Main main = new Main();

    }
































    public void parallelSum(){
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 1000000; i++) {
            numbers.add(i);
        }

        long result = numbers.stream().reduce((a,b)-> a+b).get();
//        long result = numbers.parallelStream().reduce((a,b)-> a+b).get();
        System.out.println(result);
    }

    public void groupingByAge(){
        List<Person> people = Arrays.asList(
                new Person("Alice", 23),
                new Person("Bob", 35),
                new Person("Charlie", 29),
                new Person("David", 42),
                new Person("Eve", 30)
        );

        HashMap<String,Integer> map = people.stream().collect(Collectors.toMap(person -> person.getName(), person -> person.getAge(),(p1,p2)->p1,LinkedHashMap::new));


        Map<String,Long> groups = people.stream().collect(Collectors.groupingBy(value -> {
            if (value.getAge() > 30){
                return "Seniors";
            }
            return "Juniors";
        },Collectors.counting()));

        System.out.println(groups);
    }


    public void filterStringHavingLength(){


        List<String> strings = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");
        String list = strings.stream().filter(str-> str.length()>4).peek(System.out::println).collect(Collectors.joining(""));

        System.out.println(list);
    }

    public void secondLargestUsingStream(){
        int ar[]= {1,4,21,5,24,25,33,23,291};
       OptionalInt result = Arrays.stream(ar).boxed().mapToInt(Integer::intValue).sorted().distinct().skip(ar.length-2).findFirst();
        System.out.println(result.getAsInt());;
    }

    public void reverseStringWithStream(){

        String input = "abc";
        input = Stream.of(input.split("")).reduce((s1,s2)-> s2+s1).get();
        System.out.println(input);

    }
    public String reverseIpString(String ip){
        if (ip.isEmpty()) return "";
        return ip.substring(1)+ ip.charAt(0);
    }

    public void checkLinkedListOperations(){
        LinkedList list = new LinkedList();

        list.insertNode(10);
        list.insertNode(20);
        list.insertNode(30);
        list.insertNode(40);
        list.insertNode(50);

        list.displayList();

        list.deleteNode(10);

        list.displayList();
    }


    public void reverseStringWithZigZagPattern(){
        String s="india is my country";
        //output =

        String ar[] = s.split(" ");
        
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ar.length; i++) {
            if(i%2==1){
              String temp = ar[i];
              ar[i] = ar[i-1];
              ar[i-1] = temp;
            }
        }
    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    // Constructor, getters, and setters
}