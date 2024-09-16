package org.demo;

public class Customer {
    private String name;
    private int age;
    private String surname;
    private String address;

    private Customer(Builder builder){
        this.name = builder.name;
        this.surname = builder.surname;
        this.age = builder.age;
        this.address = builder.address;

    }

    public static class Builder{

        private String name;
        private int age;
        private String surname;
        private String address;

        public static Builder builder(){
            return new Builder();
        }

        private Builder name(String name){
            this.name = name;
            return this;
        }

        private Builder surname(String surname){
            this.surname = surname;
            return this;
        }

        private Builder age(int age){
            this.age = age;
            return this;
        }
        private Builder address(String address){
            this.address = address;
            return this;
        }

        private Customer build(){
            return new Customer(this);
        }
    }
}
