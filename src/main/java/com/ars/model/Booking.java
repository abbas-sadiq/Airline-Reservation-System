package com.ars.model;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Table(name = "bookings") // Updated table name for better convention
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private int userId;

    @NotNull
    private long flightId;

    @NotNull
    @Temporal(TemporalType.DATE) // Specifies the format of the Date
    private Date date;

    // Default Constructor
    public Booking() {
    }

    // Getters and Setters
    public int getId() {
        return id;
    }





    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    public Date getDate() { // Fixed return type
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
