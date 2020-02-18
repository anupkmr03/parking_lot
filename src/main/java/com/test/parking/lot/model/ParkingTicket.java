package com.test.parking.lot.model;

import java.util.Date;

/**
 * @author anup on 2019-12-12 02:41
 * @project parking_lot
 */
public class ParkingTicket {
    private String ticketNo;
    private int amount;
    private ParkingSpot parkingSpot;

    public ParkingTicket(String ticketNo, ParkingSpot parkingSpot) {
        this.ticketNo = ticketNo + getDate(); //unique for every car
        this.amount = 10; // default
        this.parkingSpot = parkingSpot;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    private String getDate() {
        return new Date().toString();
    }
}
