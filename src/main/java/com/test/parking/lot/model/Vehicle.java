package com.test.parking.lot.model;

/**
 * @author anup on 2019-12-12 02:40
 * @project parking_lot
 */
public abstract class Vehicle {

    protected String registrationNo;

    private ParkingTicket parkingTicket;

    private VehicleType vehicleType;

    public Vehicle(String registrationNo, VehicleType vehicleType) {
        this.registrationNo = registrationNo;
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public ParkingTicket getParkingTicket() {
        return parkingTicket;
    }

    public void setParkingTicket(ParkingTicket parkingTicket) {
        this.parkingTicket = parkingTicket;
    }
}
