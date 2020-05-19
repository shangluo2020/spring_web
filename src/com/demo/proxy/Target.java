package com.demo.proxy;

public class Target implements Showable {


    @Override
    public void show() {
        System.out.println("this is show target1..");
    }

    @Override
    public String display() {
        System.out.println("this is target1 display's method!");

        return "Target1 Display";
    }
}
