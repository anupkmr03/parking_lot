package com.test.parking.lot.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author anup on 2019-12-12 02:30
 * @project parking_lot
 */
public class FileReader {
    private static Logger logger = Logger.getLogger(FileReader.class.getName());

    public static List<String> read(String fileName) {
        List<String> lines = null;
        try {
            Path path = Paths.get(fileName);
            lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            logger.log(Level.WARNING, "exception " + e.getMessage());
        }

        return lines;
    }
}
