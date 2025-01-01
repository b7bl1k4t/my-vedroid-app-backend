package com.example.test1.domain.models;

public class StatisticalDataModel {
    private String category;
    private double value;

    public StatisticalDataModel(String category, double value) {
        this.category = category;
        this.value = value;
    }

    // Getters
    public String getCategory() {
        return category;
    }

    public double getValue() {
        return value;
    }
}

