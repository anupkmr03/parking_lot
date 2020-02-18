package com.test.parking.lot.command;

import com.test.parking.lot.constants.Constants;
import com.test.parking.lot.model.ParkingLot;
import com.test.parking.lot.model.ParkingSpot;
import com.test.parking.lot.util.ValidationUtil;

import java.util.logging.Logger;

/**
 * @author anup on 2019-12-12 13:32
 * @project parking_lot
 */
public class ParkLotStatsActionHandler implements ActionHandler {
    private Logger logger = Logger.getLogger(ParkLotStatsActionHandler.class.getName());

    @Override
    public String execute(String command) {
        //input parameter is not used here
        if (!ValidationUtil.isAlreadyCreated(getParkingLotService().getParkingLot())) {
            return Constants.PARKING_LOT_NOT_CRATED;
        }
        ParkingLot parkingLot = getParkingLotService().getParkingLot();
        StringBuilder sb = new StringBuilder();
        sb.append("Slot No.").append("  ").append("Registration No.").append("\n");


        for (ParkingSpot spot : parkingLot.getParkingSpotList()) {
            if (!spot.isAvailable()) {
                sb.append(spot.getSpotNumber()).append("\t ")
                        .append(spot.getParkedVehicle().getRegistrationNo())
                        .append("\n");
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
