package com.shirucodes.angaza.models;

public class Paragraph {
    String paragraphText;
    int paragraphScore;
    String paragraphAuthenticity;

    public Paragraph() {

    }

    public Paragraph(String paragraphText, int paragraphScore, String paragraphAuthenticity) {
        this.paragraphText = paragraphText;
        this.paragraphScore = paragraphScore;
        this.paragraphAuthenticity = paragraphAuthenticity;
    }

    public String getParagraphText() {
        return paragraphText;
    }

    public void setParagraphText(String paragraphText) {
        this.paragraphText = paragraphText;
    }

    public int getParagraphScore() {
        return paragraphScore;
    }

    public void setParagraphScore(int paragraphScore) {
        this.paragraphScore = paragraphScore;
    }

    public String getParagraphAuthenticity() {
        return paragraphAuthenticity;
    }

    public void setParagraphAuthenticity(String paragraphAuthenticity) {
        this.paragraphAuthenticity = paragraphAuthenticity;
    }

    @Override
    public String toString() {
        return "Paragraph{" +
                "paragraphText='" + paragraphText + '\'' +
                ", paragraphScore=" + paragraphScore +
                ", paragraphAuthenticity='" + paragraphAuthenticity + '\'' +
                '}';
    }
}
