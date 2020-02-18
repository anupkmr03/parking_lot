package com.test.parking.lot.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author anup on 2019-12-12 02:51
 * @project parking_lot
 */
public class ParkingLot {
    private final int capacity;

    private List<ParkingSpot> parkingSpotList = new ArrayList<>();
    private Map<String, ParkingSpot> vehicleSpotMapping = new HashMap<>();

    public ParkingLot(int size) {
        this.capacity = size;
        for (int i = 1; i <= capacity; i++) {
            ParkingSpot parkingSpot = new ParkingSpot();
            parkingSpot.setSpotNumber(i);
            parkingSpotList.add(parkingSpot);
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public Map<String, ParkingSpot> getVehicleSpotMapping() {
        return vehicleSpotMapping;
    }

    public List<ParkingSpot> getParkingSpotList() {
        return parkingSpotList;
    }

}
