package com.shirucodes.angaza.models;

public class Verification {

    String date;
    String description;
    int score;

    public Verification() {
    }

    public Verification(String date, String description, int score) {
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Verification{" +
                "date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", score=" + score +
                '}';
    }
}

