package com.test.parking.lot.util;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author anup on 2019-12-12 14:11
 * @project parking_lot
 */
public class FileReaderTest {
    @Test
    public void testRead() {
        String fileName = System.getProperty("user.dir") + "/test.txt";
        List<String> read = FileReader.read(fileName);
        String str = read.get(0);
        assertEquals("parking_lot", str);
    }


    @Test
    public void testReadException() {
        String fileName = System.getProperty("user.dir") + "/test_not_available.txt";
        List<String> read = FileReader.read(fileName);
        assertNull(read);
    }
}
