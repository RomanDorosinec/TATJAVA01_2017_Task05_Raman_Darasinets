package com.epam.task5.bean;

/**
 *
 */
public class Dish {
    private String photo;
    private String title;
    private String description;
    private String portion;
    private String cost;

    public Dish(){

    }

    public Dish(String photo, String title, String description, String portion, String cost){
        this.photo = photo;
        this.title = title;
        this.description = description;
        this.portion = portion;
        this.cost = cost;
    }

    public String getPhoto() {
        return photo;
    }

    @Override
    public String toString() {
        return  "photo='" + photo + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", portion='" + portion + '\'' +
                ", cost='" + cost + '\'';
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPortion() {
        return portion;
    }

    public void setPortion(String portion) {
        this.portion = portion;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
