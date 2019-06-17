/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeastBot;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.Point;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * BEASTBOT: final project
 *
 * @author Joshua Pow, Bryan Serra, Joe Yeah
 * @since May 31, 2019
 */
public class KeysData {
    public int keyN;
    public Point[] buttonCoords;
    public long[] resetMemo;
    public Color[] keyColors;

    /**
     * default constructor for initializing private fields
     *
     */
    public KeysData() {

        buttonCoords = new Point[keyN];
        keyColors = new Color[keyN];
        resetMemo = new long[keyN];
        try {
            robot = new Robot();
        } catch (AWTException aWTException) {
            System.out.println("Fatal Error.");
            System.out.println(aWTException.getMessage());
        }
    }

    public void setKeyN(int n) {
        keyN = n;
        buttonCoords = new Point[keyN];
        keyColors = new Color[keyN];
        resetMemo = new long[keyN];
        for (int i = 0; i < keyN; i++) {
            buttonCoords[i] = new Point(0, 0);
            keyColors[i] = new Color(0, 0, 0);
        }
    }
    
    /**
     * Writes coordinates of keys to file
     * 
     */
    public void writeConfig() {

        try {
            // Writes to the specified file path
            FileWriter fileWriter = new FileWriter(CONFIGFILENAME);

            // Creates a buffer for the file writeConfig
            try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                // For every month in the months array add it to a new line in the text file
                for (Point coords : buttonCoords) {
                    bufferedWriter.write(Integer.toString(coords.x));
                    bufferedWriter.newLine();
                    bufferedWriter.write(Integer.toString(coords.y));
                    bufferedWriter.newLine();
                }
            }

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(CONFIGFILENAME + " not found.");
            System.out.println(fileNotFoundException.getMessage());
        } catch (IOException iOException) {
            System.out.println(iOException.getMessage());
        }

    }

    /**
     * reads configuration file
     * 
     * @return the number of coordinates pairs read
     */
    public int readConfig() {
        
        // creats a file for team names
        File config = new File(CONFIGFILENAME);
        
        // number of coordinates pairs
        int n = 0;
        // creates scanner for team names
        try (Scanner fin = new Scanner(config)) {
            // loops as long as theres lines to read in names file
            while (fin.hasNextLine()) {
                buttonCoords[n].x = Integer.parseInt(fin.nextLine());
                buttonCoords[n].y = Integer.parseInt(fin.nextLine());
                n++;
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(CONFIGFILENAME + " is not found.");
            System.out.println(fileNotFoundException.getMessage());
        }
        return n;
    }

    /**
     * This method is used to display the rules at the user's request
     */
    public void printInstructionManual() {
        System.out.println("First, you want to access http://www.flashflashrevolution.com/FFR_the_Game.php");
        System.out.println("Log in as Guest, and then select [OPTIONS].");
        System.out.println("[Main] section:");
        System.out.println("-Change Scroll Speed to anything 0.7 - 3.0 for optimal results");
        System.out.println("-Change Keys to Z - Left, X - Down, N - Up, M - Right");
        System.out.println("[Visual & Game Modifiers] section:");
        System.out.println("-Select 'SM Orbular' or ‘BeatMania (v2)’ under NoteSkin");
        System.out.println("[Game & Text Colors] section:");
        System.out.println("-Select 'Red' for every Note Color under Note Colors");
        System.out.println("To stop, pause song and end program :) ");

    }

    public void getCoordsForKey(int i) {

        Scanner input = new Scanner(System.in);
        System.out.println("Place mouse on note " + (i + 1) + " & press any button to config the button");
        input.next();
        buttonCoords[i] = MouseInfo.getPointerInfo().getLocation();
    }

    public void pressKey(int i) {

        if (keyColors[i].getRed() > 230 && keyColors[i].getBlue() < 30 && (System.currentTimeMillis() - resetMemo[i]) > 100) {
            robot.keyPress(HITKEYS[i]);
            robot.keyRelease(HITKEYS[i]);
            resetMemo[i] = System.currentTimeMillis();
            System.out.println("Pressed " + i + 1);
        }
    }
    
    public Color getPixelColor(int x, int y) {
        return robot.getPixelColor(x, y);
    }

    
    private static final int[] HITKEYS = new int[]{KeyEvent.VK_Z, KeyEvent.VK_X, KeyEvent.VK_N, KeyEvent.VK_M};
    private static final String CONFIGFILENAME = "config.txt"; // The name of the file to write to
    
    private Robot robot;
}
