package com.demo.proxy;

public class Target2 implements  Showable {
    @Override
    public void show() {
        System.out.println( "this is show target2..");
    }

    @Override
    public String display() {
        System.out.println("this is  target2 display's method!");
        return "Target2 Display";
    }
}
