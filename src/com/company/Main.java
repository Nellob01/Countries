package com.company;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        HashMap< String, ArrayList<Country>> country = new HashMap<>();
        ArrayList<Country> country1 = new ArrayList<>();

        File f = new File("Countries.txt");
        Scanner fileScanner = new Scanner(f);
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\|");
            Country c  = new Country(columns[1], columns[0]);
            country1.add(c);
                if(country.containsKey(c.name.substring(0, 1))) {
                    ArrayList<Country> s = country.get(c.name.substring(0, 1));
                    s.add(c);

                }
                else {
                    ArrayList<Country> s = new ArrayList<>();
                    s.add(c);
                    country.put(c.name.substring(0, 1), s); }


        }
        Scanner consoleScanner = new Scanner(System.in);
        System.out.println("Please enter a letter");
        String input = consoleScanner.nextLine();
        if(input.length() > 1) {
            throw new Exception("Please enter a letter");

        }
        ArrayList<Country> s = country.get(input.toLowerCase());
        File b = new File(input + "_Countries.txt");
        FileWriter fw = new FileWriter(b);
        for (Country n: s){
            fw.append(n.name + "\n");


        }
        fw.close();





        }

	// write your code here
    }


