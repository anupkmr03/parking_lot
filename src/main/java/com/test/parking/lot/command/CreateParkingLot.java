package com.test.parking.lot.command;

import com.test.parking.lot.constants.Constants;
import com.test.parking.lot.util.ValidationUtil;

import java.util.logging.Logger;

/**
 * @author anup on 2019-12-12 02:52
 * @project parking_lot
 */
public class CreateParkingLot implements ActionHandler {
    private Logger logger = Logger.getLogger(CreateParkingLot.class.getName());

    @Override
    public String execute(String command) {
        String[] s = command.split(" ");
        if (ValidationUtil.isValidInputInt(s[1])) {
            return Constants.INVALID_PARKING_SIZE;
        }
        if (ValidationUtil.isAlreadyCreated(getParkingLotService().getParkingLot())) {
            return Constants.PARKING_LOT_ALREADY_CREATED;
        }
        getParkingLotService().createParkingLot(Integer.valueOf(s[1]));
        return Constants.PARKING_CREATED_SUCCESS + s[1] + " slots";
    }
}
