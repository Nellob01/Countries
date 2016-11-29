package com.company;

import org.junit.Test;

import java.io.FileWriter;
import java.io.File;
import java.util.Scanner;

/**
 * Created by noelaniekan on 11/29/16.
 */
public class CountryTest {
    @Test
    public void testFileWrite() throws Exception {
        Country country = new Country("Benin", "BJ");
        File n = new File("test.txt");
        FileWriter fw = new FileWriter(n);
        Main.filewrite(fw, country);
        fw.close();

        Scanner fileScanner = new Scanner(n);
        fileScanner.nextLine();
    }
}
