package com.example.firstproject.ioc;

import org.springframework.stereotype.Component;

@Component
public class IngredientFactory {

    public Ingredient get(String menu) {
        switch (menu) {
            case "Pork Cutlet":
                return new Pork("Korean Pork Sirloin ");
            case "Steak":
                return new Beef("Korean Beef Sirloin ");
            case "Chicken":
                return new Chicken("Domestic Seasoned Crispy ");
            default:
                return null;
        }
    }
}
