package com.example.firstproject.ioc;

public class Chef {

//    public String cook(String menu) {
//
//        Pork pork = new Pork("Korean Beef Sirloin ");
//        return  pork.getName() + menu;
//
//    }

    public String cook(String menu) {
        Beef beef = new Beef("Korean Beef Sirloin ");
        return beef.getName() + menu;
    }

}
