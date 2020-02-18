package com.test.parking.lot.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author anup on 2019-12-12 14:12
 * @project parking_lot
 */
public class ParkingLotTest {
    @Test
    public void testExecuteInputCommand() {
        ParkingLot parkingLot = new ParkingLot(6);
        assertEquals(6, parkingLot.getCapacity());
        assertEquals(6, parkingLot.getParkingSpotList().size());
    }
}
