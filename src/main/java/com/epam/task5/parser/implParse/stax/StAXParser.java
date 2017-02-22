package com.epam.task5.parser.implParse.stax;

import com.epam.task5.bean.Dish;
import com.epam.task5.bean.MenuNames;
import com.epam.task5.bean.MenuTags;
import com.epam.task5.parser.XMLParse;
import com.epam.task5.parser.exception.ParserException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 */
public class StAXParser implements XMLParse {

    private String tagName;

    @Override
    public HashMap<String, ArrayList<Dish>> getMeals(String xmlPath) throws ParserException {
        HashMap<String, ArrayList<Dish>> allDish;
        XMLInputFactory inputFactory = XMLInputFactory.newFactory();
        try {
            InputStream inputStream = new FileInputStream(xmlPath);
            XMLStreamReader reader = inputFactory.createXMLStreamReader(inputStream);
            allDish = process(reader);
        } catch (FileNotFoundException | XMLStreamException e) {
            throw new ParserException(e);
        }
        return allDish;
    }

    private HashMap<String, ArrayList<Dish>> process(XMLStreamReader reader) throws XMLStreamException {
        HashMap<String, ArrayList<Dish>> allDish = new HashMap<>();
        ArrayList<Dish> dishes = null;
        ArrayList<String> ingredients = null;
        ArrayList<String> costs = null;
        Dish dish = null;

        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    tagName = reader.getLocalName();
                    switch (tagName) {
                        case MenuNames.COLD_SNACKS:
                            dishes = new ArrayList<>();
                            break;
                        case MenuNames.HOT_SNACKS:
                            dishes = new ArrayList<>();
                            break;
                        case MenuNames.BREAKFAST:
                            dishes = new ArrayList<>();
                            break;
                        case MenuTags.DESCRIPTION:
                            ingredients = new ArrayList<>();
                            costs = new ArrayList<>();
                            break;
                        case MenuTags.MEAL:
                            dish = new Dish();
                            dish.setTitle(reader.getAttributeValue(null, MenuTags.TITLE));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    tagName = reader.getLocalName();
                    switch (tagName) {
                        case MenuNames.COLD_SNACKS:
                            allDish.put(MenuNames.COLD_SNACKS, dishes);
                            break;
                        case MenuNames.HOT_SNACKS:
                            allDish.put(MenuNames.HOT_SNACKS, dishes);
                            break;
                        case MenuNames.BREAKFAST:
                            allDish.put(MenuNames.BREAKFAST, dishes);
                            break;
                        case MenuTags.MEAL:
                            dishes.add(dish);
                            break;
                        case MenuTags.DESCRIPTION:
                            dish.setDescription(lineBuilder(ingredients));
                            dish.setCost(lineBuilder(costs));
                            break;
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    String text = reader.getText().trim();
                    if (text.isEmpty()) {
                        break;
                    }
                    switch (tagName) {
                        case MenuTags.PHOTO:
                            dish.setPhoto(text);
                            break;
                        case MenuTags.PORTION:
                            dish.setPortion(text);
                            break;
                        case MenuTags.INGREDIENT:
                            ingredients.add(text);
                            break;
                        case MenuTags.COST:
                            costs.add(text);
                            break;
                    }
                    break;
            }
        }
        return allDish;
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
