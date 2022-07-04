package com.example.demo;


public class CreateUniqueID {

    public static void main(String[] args) {
        System.out.println("start main");

        IDConverter instance = IDConverter.INSTANCE;
        System.out.println(instance.createUniqueID(104573478357L));




        System.out.println("end main");
    }


}