package com.test.parking.lot.model;

/**
 * @author anup on 2019-12-12 02:52
 * @project parking_lot
 */
public class ParkingSpot {
    private int spotNumber;
    private Vehicle parkedVehicle;

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void setParkedVehicle(Vehicle parkedVehicle) {
        this.parkedVehicle = parkedVehicle;
    }

    public boolean isAvailable() {
        return parkedVehicle == null;
    }

}
