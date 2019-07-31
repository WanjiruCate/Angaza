package com.shirucodes.angaza.models;

public class Verification {

    String date;
    String description;

    public Verification(String date, String description) {
        this.date = date;
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Verification{" +
                "date='" + date + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

