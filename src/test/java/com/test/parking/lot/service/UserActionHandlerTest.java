package com.test.parking.lot.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author anup on 2019-12-12 14:12
 * @project parking_lot
 */
public class UserActionHandlerTest {
    private UserActionHandler userActionHandler;

    @Before
    public void before() {
        userActionHandler = new UserActionHandler();
    }

    @Test
    public void testExecuteInputCommand() {
        boolean status = userActionHandler.executeInputCommand("status");
        assertTrue(status);
    }
}
