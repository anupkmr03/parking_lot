package com.test.parking.lot.command;

import com.test.parking.lot.service.ParkingLotService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author anup on 2019-12-12 14:13
 * @project parking_lot
 */
public class ParkOutActionHandlerTest {
    private ParkingLotService parkingLotService;
    private ParkOutActionHandler parkOutActionHandler;
    private ParkInActionHandler parkInActionHandler;

    @Before
    public void before() {
        parkOutActionHandler = new ParkOutActionHandler();
        parkInActionHandler = new ParkInActionHandler();
        parkingLotService = ParkingLotService.getInstance();
    }

    @Test
    public void testExecute() {
        String input = "park KA-01-HH-1234";
        parkingLotService.createParkingLot(3);
        parkInActionHandler.execute(input);
        String execute = parkOutActionHandler.execute("leave KA-01-HH-1234 4");
        assertEquals(execute, "Registration number KA-01-HH-1234\n" +
                "with Slot Number 1 is free with Charge 30");
        assertEquals(true, parkingLotService.getParkingLot()
                .getParkingSpotList().get(0).getParkedVehicle() == null);
    }
}
