package com.test.parking.lot.command;

import com.test.parking.lot.constants.Constants;
import com.test.parking.lot.util.ValidationUtil;
import com.test.parking.lot.model.*;

/**
 * @author anup on 2019-12-12 13:31
 * @project parking_lot
 */
public class ParkInActionHandler implements ActionHandler {
    @Override
    public String execute(String command) {
        String[] commandArr = command.split(Constants.COMMAND_DLIM);

        if (!ValidationUtil.isAlreadyCreated(getParkingLotService().getParkingLot())) {
            return Constants.PARKING_LOT_NOT_CRATED;
        }
        ParkingLot parkingLot = getParkingLotService().getParkingLot();
        Vehicle car = new Car(commandArr[1]);
        ParkingSpot parkedSpot = park(parkingLot, car);

        if (parkedSpot == null) {
            return Constants.PARKING_LOT_FULL;
        } else {
            return "Allocated slot number: " + parkedSpot.getSpotNumber();
        }
    }

    private ParkingSpot park(ParkingLot parkingLot, Vehicle car) {
        for (ParkingSpot spot : parkingLot.getParkingSpotList()) {
            if (spot.isAvailable()) {
                spot.setParkedVehicle(car);
                car.setParkingTicket(
                        new ParkingTicket(car.getRegistrationNo(), spot));
                parkingLot.getVehicleSpotMapping()
                        .put(car.getRegistrationNo(), spot);
                return spot;
            }
        }
        return null;
    }
}
