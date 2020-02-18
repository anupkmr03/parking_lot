package com.test.parking.lot.command;

import com.test.parking.lot.constants.Constants;
import com.test.parking.lot.service.ParkingLotService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author anup on 2019-12-12 14:13
 * @project parking_lot
 */
public class ParkInActionHandlerTest {
    private ParkingLotService parkingLotService;
    private ParkInActionHandler parkInActionHandler;

    @Before
    public void before() {
        parkInActionHandler = new ParkInActionHandler();
        parkingLotService = ParkingLotService.getInstance();
    }

    @Test
    public void testExecute() {
        String input = "park KA-01-HH-1234";
        parkingLotService.createParkingLot(3);
        parkInActionHandler.execute(input);
        assert (parkingLotService.getParkingLot().getParkingSpotList()
                .get(0).getParkedVehicle().getRegistrationNo().equals("KA-01-HH-1234"));
    }

    @Test
    public void testExecuteNegative() {
        String[] input = {"park KA-01-HH-1234", "park KA-01-HH-1235",
                "park KA-01-HH-1236", "park KA-01-HH-1237"};
        parkingLotService.createParkingLot(3);
        String execute = "";
        for (String ex : input) {
            execute = parkInActionHandler.execute(ex);
        }
        assertTrue(execute.equals(Constants.PARKING_LOT_FULL));
    }
}
