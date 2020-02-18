package com.test.parking.lot;

import com.test.parking.lot.constants.Constants;
import com.test.parking.lot.service.UserActionHandler;
import com.test.parking.lot.util.FileReader;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author anup on 2019-12-12 02:28
 * @project parking_lot
 */
public class ParkingLotApp {
    private static Logger logger = Logger.getLogger(ParkingLotApp.class.getName());
    private UserActionHandler userActionHandler;

    public ParkingLotApp() {
        userActionHandler = new UserActionHandler();
    }

    public static void main(String[] args) {
        if (args.length > 1) {
            logger.log(Level.INFO, "invalid input");
            return;
        }
        ParkingLotApp app = new ParkingLotApp();
        if (args.length == 0) {
            logger.log(Level.INFO, "command mode started...\n" +
                    "please enter input command below");
            app.executeInteractiveMode();
        } else {
            String file = args[0];
            logger.log(Level.INFO, "file mode started input file : " + file);
            app.executeFileMode(file);
        }
    }

    public void executeFileMode(String filePath) {
        List<String> commands = FileReader.read(filePath);
        for (String line : commands) {
            userActionHandler.executeInputCommand(line);
        }

    }

    public void executeInteractiveMode() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            if ("exit".equalsIgnoreCase(line)) {
                scanner.close();
                logger.log(Level.INFO, "exiting....");
                break;
            }
            if (!Constants.EMPTY.equals(line))
                userActionHandler.executeInputCommand(line);
        }

    }
}
