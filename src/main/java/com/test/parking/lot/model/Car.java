package com.test.parking.lot.model;

/**
 * @author anup on 2019-12-12 02:40
 * @project parking_lot
 */
public class Car extends Vehicle {
    private String color; //optional field


    public Car(String registrationNo) {
        super(registrationNo, VehicleType.CAR);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
