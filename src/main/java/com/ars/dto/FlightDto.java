package com.ars.dto;

public class FlightDto {

    private int flightId;
    private String flightName;
    private String flightType;
    private String flightDate;
    private String flightTime;
    private String flightSeat;
    private String flightSeatType;
    private String flightSeatNumber;

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getFlightType() {
        return flightType;
    }

    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }

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

    public String getFlightSeat() {
        return flightSeat;
    }

    public void setFlightSeat(String flightSeat) {
        this.flightSeat = flightSeat;
    }


    public String getFlightSeatNumber() {
        return flightSeatNumber;
    }

    public void setFlightSeatNumber(String flightSeatNumber) {
        this.flightSeatNumber = flightSeatNumber;
    }
}
