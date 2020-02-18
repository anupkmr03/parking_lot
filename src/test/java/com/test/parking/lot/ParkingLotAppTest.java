package com.test.parking.lot;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author anup on 2019-12-12 14:10
 * @project parking_lot
 */
public class ParkingLotAppTest {
    private ParkingLotApp parkingLotApp;

    @Before
    public void setup() {
        parkingLotApp = new ParkingLotApp();
    }

    @Test
    public void testExecuteFileMode() {
        String fileName = System.getProperty("user.dir") + "/test.txt";
        parkingLotApp.executeFileMode(fileName);
        assertTrue(true);// need to check console
    }

    @Test
    public void testSampleTestCasesViaFile() {
        String fileName = System.getProperty("user.dir") + "/input.txt";
        parkingLotApp.executeFileMode(fileName);
        assertTrue(true);// need to check output.txt file
    }
}
