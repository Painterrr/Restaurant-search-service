package com.example.firstproject.ioc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChefTest {

    @Test
    void porkCutlets() {
        // set
        Chef chef = new Chef();
        String menu = "Pork Cutlet";
        // execute
        String food = chef.cook(menu);

        // actual
        String expected = "Korean Beef Sirloin Pork Cutlet";

        // check
        assertEquals(expected, food);
        System.out.println("food: " + food);
    }

    @Test
    void steak() {
        // set
        Chef chef = new Chef();
        String menu = "Steak";

        // execute
        String food = chef.cook(menu);

        // actual
        String expected = "Korean Beef Sirloin Steak";

        // check
        assertEquals(expected, food);
        System.out.println("food: " + food);
    }
}