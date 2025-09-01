package com.example.demo.DTO;

public class LocationAverageDTO {
    private String location;
    private int averagePrice;

    public LocationAverageDTO(String location, int averagePrice) {
        this.location = location;
        this.averagePrice = averagePrice;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(int averagePrice) {
        this.averagePrice = averagePrice;
    }
}

