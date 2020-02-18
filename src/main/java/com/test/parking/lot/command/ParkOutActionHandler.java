package com.test.parking.lot.command;

import com.test.parking.lot.constants.Constants;
import com.test.parking.lot.model.ParkingLot;
import com.test.parking.lot.model.ParkingSpot;
import com.test.parking.lot.model.Vehicle;
import com.test.parking.lot.util.ValidationUtil;

/**
 * @author anup on 2019-12-12 13:33
 * @project parking_lot
 */
public class ParkOutActionHandler implements ActionHandler {
    @Override
    public String execute(String command) {
        String[] s = command.split(Constants.COMMAND_DLIM);
        String registrationNo = s[1];
        String hours = s[2];

        if (!ValidationUtil.isAlreadyCreated(getParkingLotService().getParkingLot())) {
            return Constants.PARKING_LOT_NOT_CRATED;

        }
        if (!ValidationUtil.isValidRegNo(registrationNo)) {
            return Constants.INVALID_INPUT;
        }

        if (ValidationUtil.isValidInputInt(hours)) {
            return Constants.INVALID_INPUT;
        }

        ParkingLot parkingLot = getParkingLotService().getParkingLot();
        return removeVehicleFromParkingLot(parkingLot, registrationNo, Integer.valueOf(hours));
    }

    private String removeVehicleFromParkingLot(ParkingLot parkingLot, String registrationNo, int hours) {
        StringBuilder outputMsg = new StringBuilder();

        ParkingSpot parkingSpot = parkingLot.getVehicleSpotMapping().get(registrationNo);
        if (parkingSpot != null) {
            Vehicle vehicle = parkingSpot.getParkedVehicle();
            int amount = vehicle.getParkingTicket().getAmount();
            if (hours >= 2) {
                hours -= 2;
            } else {
                hours = 0;
            }
            amount += hours * 10;
            outputMsg.append("Registration number ")
                    .append(registrationNo).append("\n").append("with Slot Number ")
                    .append(parkingSpot.getSpotNumber()).append(" is free with Charge ")
                    .append(amount);

            parkingSpot.setParkedVehicle(null);
            parkingLot.getVehicleSpotMapping().remove(registrationNo);
        } else {
            outputMsg.append("Registration number ").append(registrationNo).append(" not found");
        }
        return outputMsg.toString();
    }
}
