package com.example.StudySpringBoot.entity;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("CLOTH")
public class CLOTH extends SOPUM {

    private String maker;

    // Getters and Setters
    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }
}
