package com.example.StudySpringBoot.entity;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("FOOD")
public class FOOD extends SOPUM {

    private String menu;

    // Getters and Setters
    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }
}
