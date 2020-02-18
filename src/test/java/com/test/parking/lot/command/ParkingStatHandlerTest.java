package com.test.parking.lot.command;

import com.test.parking.lot.service.ParkingLotService;
import org.junit.Before;
import org.junit.Test;

/**
 * @author anup on 2019-12-12 14:14
 * @project parking_lot
 */
public class ParkingStatHandlerTest {
    private ParkingLotService parkingLotService;
    private ParkInActionHandler parkInActionHandler;
    private ParkLotStatsActionHandler parkLotStatsActionHandler;

    @Before
    public void before() {
        parkInActionHandler = new ParkInActionHandler();
        parkLotStatsActionHandler = new ParkLotStatsActionHandler();
        parkingLotService = ParkingLotService.getInstance();
    }

    @Test
    public void testExecute() {
        String input = "park KA-01-HH-1234";
        parkingLotService.createParkingLot(3);
        parkInActionHandler.execute(input);
        String status = this.parkLotStatsActionHandler.execute("status");
        assert (status.contains("KA-01-HH-1234"));
    }
}
