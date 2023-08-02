package com.example.firstproject.ioc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChefTest {

    @Autowired
    IngredientFactory ingredientFactory;
    @Autowired
    Chef chef;

    @Test
    void porkCutlets() {
        // set
//        IngredientFactory ingredientFactory = new IngredientFactory();
//        Chef chef = new Chef(ingredientFactory);
        String menu = "Pork Cutlet";

        // expected
        String food = chef.cook(menu);

        // actual
        String expected = "Korean Pork Sirloin Pork Cutlet";

        // check
        assertEquals(expected, food);
        System.out.println("food: " + food);
    }

    @Test
    void steak() {
        // set
//        IngredientFactory ingredientFactory = new IngredientFactory();
//        Chef chef = new Chef(ingredientFactory);
        String menu = "Steak";

        // expected
        String food = chef.cook(menu);

        // actual
        String expected = "Korean Beef Sirloin Steak";

        // check
        assertEquals(expected, food);
        System.out.println("food: " + food);
    }

    @Test
    void crispyChicken() {
        // set
//        IngredientFactory ingredientFactory = new IngredientFactory();
//        Chef chef = new Chef(ingredientFactory);
        String menu = "Chicken";

        // expected
        String food = chef.cook(menu);

        // actual
        String expected = "Domestic Seasoned Crispy Chicken";

        // check
        assertEquals(expected, food);
        System.out.println("food: " + food);
    }
}