package com.epam.task5.parser.implParse.dom;

import com.epam.task5.bean.Dish;
import com.epam.task5.bean.MenuNames;
import com.epam.task5.bean.MenuTags;
import com.epam.task5.parser.XMLParse;
import com.epam.task5.parser.exception.ParserException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 */
public class DOMParser implements XMLParse {

    private Dish dish;

    private ArrayList<Dish> dishes;
    private ArrayList<String> menuCategory = new ArrayList<>();

    private HashMap<String, ArrayList<Dish>> allMeals = new HashMap<>();

    {
        menuCategory.add(MenuNames.COLD_SNACKS);
        menuCategory.add(MenuNames.HOT_SNACKS);
        menuCategory.add(MenuNames.BREAKFAST);
    }

    @Override
    public HashMap<String, ArrayList<Dish>> getMeals(String xmlPath) throws ParserException {
        try {
            com.sun.org.apache.xerces.internal.parsers.DOMParser domParser = new com.sun.org.apache.xerces.internal.parsers.DOMParser();
            domParser.parse(xmlPath);
            Document document = domParser.getDocument();

            Element root = document.getDocumentElement();

            for (String category : menuCategory) {
                Element menuNodes = getSingleElement(root, category);
                dishes = new ArrayList<>();
                NodeList dishNodes = menuNodes.getElementsByTagName(MenuTags.MEAL);
                for (int i = 0; i < dishNodes.getLength(); i++) {
                    dish = new Dish();
                    Element foodElement = (Element) dishNodes.item(i);
                    dish.setPhoto(foodElement.getElementsByTagName(MenuTags.PHOTO).item(0).getTextContent());
                    dish.setTitle(foodElement.getAttribute(MenuTags.TITLE));
                    Element descriptionNodes = getSingleElement(foodElement, MenuTags.DESCRIPTION);
                    NodeList ingredientsNodes = descriptionNodes.getElementsByTagName(MenuTags.INGREDIENTS);
                    dish.setDescription(lineBuilder(ingredientsNodes, MenuTags.INGREDIENT));
                    dish.setCost(lineBuilder(ingredientsNodes, MenuTags.COST));
                    dish.setPortion(foodElement.getElementsByTagName(MenuTags.PORTION).item(0).getTextContent());
                    dishes.add(dish);
                }
                allMeals.put(category, dishes);
            }
        } catch (SAXException | IOException e) {
            throw new ParserException(e);
        }
        return allMeals;
    }

    private String lineBuilder(NodeList ingredientsNodes, String tagName) {
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < ingredientsNodes.getLength(); j++) {
            Element ingredientsElement = (Element) ingredientsNodes.item(j);
            if (ingredientsNodes.getLength() != 1) {
                builder.append((j + 1) + ". " + ingredientsElement.getElementsByTagName(tagName).item(0).getTextContent() + "\n");
            } else {
                builder.append(ingredientsElement.getElementsByTagName(tagName).item(0).getTextContent());
            }
        }
        return builder.toString();
    }

    private Element getSingleElement(Element root, String tagName) {
        NodeList list = root.getElementsByTagName(tagName);
        Element foodElement = (Element) list.item(0);
        return foodElement;
    }
}
