/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package largest;

import org.junit.jupiter.api.Test;
import junit.framework.TestCase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Alex Boccaccio
 */
public class LargestTest {

    /**
     * Test of main method, of class Largest.
     */
    @Test
    public void testMain() {
        Scanner in;
        String input;
        int nextNumber = 0;
        ArrayList<Integer>  numbersArray = new ArrayList<>();
        try{
            in = new Scanner(new File("input.txt"));
            while(in.hasNextLine()){
                try{
                input = in.nextLine();
                nextNumber = Integer.parseInt(input);
                    // System.out.println(nextNumber);
                numbersArray.add(nextNumber);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format");
                }

            }

            in.close();
        }catch ( FileNotFoundException err){
            System.err.println(err);
        }
        int[] intArry = new int[numbersArray.size()];

        for(int i = 0; i < numbersArray.size(); i++){

            intArry[i] = numbersArray.get(i);
        }
        System.out.println("main \n ");

        Largest large = new Largest();
		int out = large.largest(intArry);
        assertEquals(80, out);


		// fail("Not yet implemented");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
