package com.ars.dto;

public class FlightDto {

    private String flightName;
    private String flightDate;
    private String flightTime;

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    public String getFlightSeatNumber() {
        return flightSeatNumber;
    }

    public void setFlightSeatNumber(String flightSeatNumber) {
        this.flightSeatNumber = flightSeatNumber;
    }

    private String flightSeatNumber;


}