/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package largest;

import org.junit.jupiter.api.Test;
import junit.framework.TestCase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.UNICODE_CHARACTER_CLASS;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Alex Boccaccio
 */
public class LargestTest {

    /**
     * Test of main method, of class Largest.
     */
    public static String[] trimSplitUnicodeBySpace(String str) {
        // https://stackoverflow.com/questions/7899525/how-to-split-a-string-by-space


        Pattern SPLIT_SPACE_UNICODE_PATTERN = Pattern.compile("\\p{Blank}+", UNICODE_CHARACTER_CLASS);
        Pattern TRIM_UNICODE_PATTERN = Pattern.compile("^\\p{Blank}*(.*)\\p{Blank}*$", UNICODE_CHARACTER_CLASS);

        Matcher trimMatcher = TRIM_UNICODE_PATTERN.matcher(str);
        boolean ignored = trimMatcher.matches();
        return SPLIT_SPACE_UNICODE_PATTERN.split(trimMatcher.group(1));
    }
    @Test
    public void testMain() {
        Scanner in;
        String input = "";
        int nextNumber = 0;
        ArrayList<ArrayList<Integer>>  numbersArrayOuter = new ArrayList<>();
        ArrayList<Integer> expectedValuesList = new ArrayList<>();
        try{
            in = new Scanner(new File("TestValues.txt"));
            int numberOfLines = 0;
            while(in.hasNextLine()){
                numberOfLines++;
                numbersArrayOuter.add(new ArrayList<Integer>());
                input = in.nextLine();
                input = input.trim();
                /* this is wholy unnessary and cost me at least a half hour as string.split("\\s+") would have worked
                // however I didn't realize the error was in another part of the code... */
                String[] inputArray = input.split("\\s+");

                try {
                    for (int i = 0; i < inputArray.length; i++) {
                        nextNumber = Integer.parseInt( inputArray[i] );
                        numbersArrayOuter.get(numberOfLines - 1).add(nextNumber);
                    }

                    // System.out.println(nextNumber);

                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format with " + input);
                }
            }
            in.close();
        }catch ( FileNotFoundException err){
            System.err.println(err);
        }
        try{
            in = new Scanner(new File("ExpectedValues.txt"));
            while(in.hasNextLine()){
                numbersArrayOuter.add(new ArrayList<Integer>());
                input = in.nextLine();
                try {
                    expectedValuesList.add(Integer.parseInt(input));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format with " + input);
                }
            }
            // System.out.println(expectedValuesList.size());
            in.close();
        }catch ( FileNotFoundException err){
            System.err.println(err);
        }

        System.out.println("Start main Test Cases \n ");
        // System.out.println( expectedValuesList.size() );
        for (int i = 0; i < expectedValuesList.size(); i++) {
            int[] intArry = new int[numbersArrayOuter.get(i).size()];

            for(int j = 0; j < numbersArrayOuter.get(i).size(); j++){
                intArry[j] = numbersArrayOuter.get(i).get(j);
            }
            // TODO unit test
            Largest large = new Largest();
            int out = large.largest(intArry);
            assertEquals(expectedValuesList.get(i), out);
            if(out == expectedValuesList.get(i)){
                System.out.println("test number " + i  + " successful");
            } else {
                System.out.println("test number " + i  + " not successful");
            }
            System.out.println(out + "  " + expectedValuesList.get(i));
        }// end looper
    }
}
