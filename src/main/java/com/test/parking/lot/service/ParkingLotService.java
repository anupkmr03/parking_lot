package com.test.parking.lot.service;

import com.test.parking.lot.model.ParkingLot;

/**
 * @author anup on 2019-12-12 13:22
 * @project parking_lot
 */
// singleton class that will share only one single instance across the whole application
public class ParkingLotService {
    private static ParkingLotService parkingLotService = null;
    private ParkingLot parkingLot;

    private ParkingLotService() {

    }

    public static ParkingLotService getInstance() {
        if (parkingLotService == null) {
            parkingLotService = new ParkingLotService();
        }
        return parkingLotService;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void createParkingLot(int size) {
        if (parkingLot == null)
            parkingLot = new ParkingLot(size);
    }
}
