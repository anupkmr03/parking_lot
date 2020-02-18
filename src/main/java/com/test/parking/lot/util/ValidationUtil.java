package com.test.parking.lot.util;

import com.test.parking.lot.model.ParkingLot;

/**
 * @author anup on 2019-12-12 13:21
 * @project parking_lot
 */
public class ValidationUtil {

    public static boolean isValidInputInt(String size) {
        try {
            int sizeNumber = Integer.valueOf(size);
            return sizeNumber < 0;
        } catch (ClassCastException e) {
            return true;
        }
    }

    /**
     * return true if parking lot is already created
     *
     * @param parkingLot
     * @return
     */
    public static boolean isAlreadyCreated(ParkingLot parkingLot) {
        return parkingLot != null && parkingLot.getCapacity() > 0;
    }


    public static boolean isValidRegNo(String registrationNo) {
        return registrationNo != null && registrationNo.split("-").length == 4;
    }

}
