package com.test.parking.lot.model;

import com.test.parking.lot.command.*;

/**
 * @author anup on 2019-12-12 02:41
 * @project parking_lot
 */
public enum UserAction {

    CREATE_PARKING_LOT(new CreateParkingLot(), 2),
    PARK(new ParkInActionHandler(), 2),
    LEAVE(new ParkOutActionHandler(), 3),
    STATUS(new ParkLotStatsActionHandler(), 1);

    public boolean validateActionInput(int userInput) {
        return this.getInputSize() == userInput;
    }

    UserAction(ActionHandler actionHandler, int inputSize) {
        this.actionHandler = actionHandler;
        this.inputSize = inputSize;
    }

    private ActionHandler actionHandler;
    private int inputSize;

    public ActionHandler getActionHandler() {
        return actionHandler;
    }

    public int getInputSize() {
        return inputSize;
    }
}
