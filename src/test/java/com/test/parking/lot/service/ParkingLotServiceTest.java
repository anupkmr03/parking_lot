package com.test.parking.lot.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author anup on 2019-12-12 14:12
 * @project parking_lot
 */
public class ParkingLotServiceTest {
    private ParkingLotService parkingLotService;

    @Before
    public void before() {
        parkingLotService = ParkingLotService.getInstance();
    }

    @Test
    public void testCreateParkingLot() {
        parkingLotService.createParkingLot(5);
        assertNotNull(parkingLotService.getParkingLot());
    }
}
