package com.epam.task5.parser.implParse.sax.handler;

import com.epam.task5.bean.Dish;
import com.epam.task5.bean.MenuNames;
import com.epam.task5.bean.MenuTags;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 */
public class MenuSaxHandler extends DefaultHandler {

    private Dish dish;

    private ArrayList<Dish> dishes;
    private ArrayList<String> ingredients;
    private ArrayList<String> costs;

    private HashMap<String, ArrayList<Dish>> allMeals = new HashMap<>();

    private StringBuilder text;

    public void startElement(String uti, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals(MenuNames.COLD_SNACKS)) {
            dishes = new ArrayList<>();
        }
        if (qName.equals(MenuNames.HOT_SNACKS)) {
            dishes = new ArrayList<>();
        }
        if (qName.equals(MenuNames.BREAKFAST)) {
            dishes = new ArrayList<>();
        }
        if (qName.equals(MenuTags.DESCRIPTION)) {
            ingredients = new ArrayList<>();
            costs = new ArrayList<>();
        }
        text = new StringBuilder();
        if (qName.equals(MenuTags.MEAL)) {
            dish = new Dish();
            dish.setTitle(attributes.getValue(MenuTags.TITLE));
        }
    }

    public void characters(char[] buffer, int start, int length) {
        text.append(buffer, start, length);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case MenuNames.COLD_SNACKS:
                allMeals.put(MenuNames.COLD_SNACKS, dishes);
                break;
            case MenuNames.HOT_SNACKS:
                allMeals.put(MenuNames.HOT_SNACKS, dishes);
                break;
            case MenuNames.BREAKFAST:
                allMeals.put(MenuNames.BREAKFAST, dishes);
                break;
            case MenuTags.MEAL:
                dishes.add(dish);
                break;
            case MenuTags.PHOTO:
                dish.setPhoto(text.toString());
                break;
            case MenuTags.PORTION:
                dish.setPortion(text.toString());
                break;
            case MenuTags.DESCRIPTION:
                dish.setDescription(lineBuilder(ingredients));
                dish.setCost(lineBuilder(costs));
                break;
            case MenuTags.INGREDIENT:
                ingredients.add(text.toString());
                break;
            case MenuTags.COST:
                costs.add(text.toString());
                break;
        }
    }

    public HashMap<String, ArrayList<Dish>> getAllDish() {
        return allMeals;
    }

    private String lineBuilder(ArrayList<String> param) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < param.size(); i++) {
            if (param.size() != 1) {
                builder.append((i + 1) + ". " + param.get(i) + "\n");
            } else {
                builder.append(param.get(i));
            }
        }
        return builder.toString();
    }
}
