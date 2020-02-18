package com.test.parking.lot.service;

import com.test.parking.lot.command.ActionHandler;
import com.test.parking.lot.constants.Constants;
import com.test.parking.lot.model.UserAction;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author anup on 2019-12-12 02:31
 * @project parking_lot
 */
public class UserActionHandler {
    private Logger logger = Logger.getLogger(UserActionHandler.class.getName());

    public boolean executeInputCommand(String line) {
        if (line == null) {
            return false;
        }
        return executeCommand(line);
    }

    private boolean executeCommand(String input) {
        try {
            String[] inputArr = input.split(" ");
            String commandName = inputArr[0];
            if (commandName == null || Constants.EMPTY.equals(commandName)) {
                return false;
            }
            UserAction commandType = getCommand(commandName);
            if (validateInput(commandType, inputArr)) {
                ActionHandler abstractCommand = commandType.getActionHandler();
                String msg = abstractCommand.execute(input);
                System.out.println(msg);
                return true;
            }
            return false;
        } catch (Exception e) {
            logger.log(Level.INFO, "error " + e.getMessage());
            System.out.println("Error while processing:" + e.getMessage());
            return false;
        }
    }

    private UserAction getCommand(String command) {
        for (UserAction commandTypes : UserAction.values()) {
            if (command.equalsIgnoreCase(commandTypes.toString())) {
                return commandTypes;
            }
        }
        return null;
    }

    private boolean validateInput(UserAction commandType, String[] inputArr) {
        if (commandType == null) {
            logger.log(Level.INFO, "invalid command");
            return false;
        }

        if (!commandType.validateActionInput(inputArr.length)) {
            logger.log(Level.INFO, "invalid argument size for command " + commandType.name());
            return false;
        }

        return true;
    }
}
