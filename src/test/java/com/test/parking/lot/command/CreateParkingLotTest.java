package com.test.parking.lot.command;

import com.test.parking.lot.service.ParkingLotService;
import org.junit.Before;
import org.junit.Test;

/**
 * @author anup on 2019-12-12 14:13
 * @project parking_lot
 */
public class CreateParkingLotTest {
    private ParkingLotService parkingLotService;
    private CreateParkingLot createParkingLot;

    @Before
    public void before() {
        createParkingLot = new CreateParkingLot();
        parkingLotService = ParkingLotService.getInstance();
    }

    @Test
    public void testExecute() {
        String input = "create_parking_lot 3";
        createParkingLot.execute(input);
        assert (parkingLotService.getParkingLot().getParkingSpotList().size() == 3);
        assert (parkingLotService.getParkingLot().getCapacity() == 3);
    }
}
