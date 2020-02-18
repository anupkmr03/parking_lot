package com.test.parking.lot.command;

import com.test.parking.lot.service.ParkingLotService;

/**
 * @author anup on 2019-12-12 02:41
 * @project parking_lot
 */
public interface ActionHandler {
    String execute(String command);

    default ParkingLotService getParkingLotService() {
        return ParkingLotService.getInstance();
    }
}
