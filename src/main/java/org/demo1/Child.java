package org.demo1;
import org.demo.Sample;

public class Child extends Sample{

    public String name;
    public static void main(String[] args) {




//        test();
        Child ch = new Child();

        ch.test();
    }
    @Override
    public boolean equals(Object obj){

        Child ch = (Child) obj;


        if (this.name.equals(ch.name))
            return true;
        return false;
    }

}
