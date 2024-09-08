package com.example.geetaapp;

public class Chapter {
    private String hindiNumber;
    private String name;
    private String nameMeaning;
    private String summary;
    private int number;

    public Chapter(String hindiNumber, String name, String nameMeaning, String summary, int number) {
        this.hindiNumber = hindiNumber;
        this.name = name;
        this.nameMeaning = nameMeaning;
        this.summary = summary;
        this.number = number;
    }

    public String getHindiNumber() {
        return hindiNumber;
    }

    public void setHindiNumber(String hindiNumber) {
        this.hindiNumber = hindiNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameMeaning() {
        return nameMeaning;
    }

    public void setNameMeaning(String nameMeaning) {
        this.nameMeaning = nameMeaning;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
