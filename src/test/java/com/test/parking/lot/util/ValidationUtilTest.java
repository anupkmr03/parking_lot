package com.test.parking.lot.util;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author anup on 2019-12-12 14:11
 * @project parking_lot
 */
public class ValidationUtilTest {
    @Test
    public void testIsValidInputInt() {
        boolean anInt = ValidationUtil.isValidInputInt("123");
        assertFalse(anInt);
    }

    @Test
    public void testIsValidInputIntNegative() {
        boolean anInt = ValidationUtil.isValidInputInt("-123");
        assertTrue(anInt);
    }

    @Test
    public void testValidateRegistrationNo() {
        boolean anInt = ValidationUtil.isValidRegNo("DL-12-AA-9999");
        assertTrue(anInt);
    }
}
