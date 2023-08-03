package com.example.firstproject.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class BurgerTest {

    @Test
    public void objectToJson() throws JsonProcessingException {
        // set
        ObjectMapper objectMapper = new ObjectMapper();
        List<String> ingredients = Arrays.asList("Whole Shrimp Patties", "All Beef Patties", "tomato", "Spicy Onion Sauce");
        Burger burger = new Burger("McDonald ShBeBurger", 5500, ingredients);

        // execute
        String json = objectMapper.writeValueAsString(burger);

        // expected
        String expected = "{\"name\":\"McDonald ShBeBurger\",\"price\":55000,\"ingredients\":[\"Whole Shrimp Patties\",\"All Beef Patties\",\"tomato\",\"Spicy Onion Sauce\"]}";

        // check
        assertEquals(expected, json);
        JsonNode jsonNode = objectMapper.readTree(json);
        System.out.println(jsonNode.toPrettyString());
    }

    @Test
    public void jsonToObject() throws JsonProcessingException {
        // set
        ObjectMapper objectMapper = new ObjectMapper();
        /*
        {
          "name" : "McDonald ShBeBurger",
          "price" : 55000,
          "ingredients" : [ "Whole Shrimp Patties", "All Beef Patties", "tomato", "Spicy Onion Sauce" ]
        }
         */
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("name", "McDonald ShBeBurger");
        objectNode.put("price", 5500);
        ArrayNode arrayNode = objectMapper.createArrayNode();
        arrayNode.add("Whole Shrimp Patties");
        arrayNode.add("All Beef Patties");
        arrayNode.add("tomato");
        arrayNode.add("Spicy Onion Sauce");
        objectNode.set("ingredients", arrayNode);
        String json = objectNode.toString();

        // execute
        Burger burger = objectMapper.readValue(json, Burger.class);

        // expected
        List<String> ingredients = Arrays.asList("Whole Shrimp Patties", "All Beef Patties", "tomato", "Spicy Onion Sauce");
        Burger expected = new Burger("McDonald ShBeBurger", 5500, ingredients);

        // check
        assertEquals(expected.toString(), burger.toString());
        JsonNode jsonNode = objectMapper.readTree(json);
        System.out.println("json: " + jsonNode.toPrettyString());
        System.out.println("burger.toString(): " + burger.toString());
    }
}