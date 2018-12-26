package com.example.network;

public class Weather {
    private Double temp;
    private String townName;
    private String countryLetters;

    public Weather() {
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }


    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getCountryLetters() {
        return countryLetters;
    }

    public void setCountryLetters(String countryLetters) {
        this.countryLetters = countryLetters;
    }
}
