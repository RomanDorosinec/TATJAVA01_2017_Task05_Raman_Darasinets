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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Dish dish = (Dish) obj;

        if (photo != null ? !photo.equals(dish.photo) : dish.photo != null) return false;
        if (title != null ? !title.equals(dish.title) : dish.title != null) return false;
        if (description != null ? !description.equals(dish.description) : dish.description != null) return false;
        if (portion != null ? !portion.equals(dish.portion) : dish.portion != null) return false;
        return cost != null ? cost.equals(dish.cost) : dish.cost == null;
    }

    @Override
    public int hashCode() {
        int result = photo != null ? photo.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (portion != null ? portion.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        return result;
    }
}
