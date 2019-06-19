package BeastBot;

import java.awt.Color;
import java.awt.Point;

/**
 * data structure that holds key information
 *
 * @author Joe Ye
 */
public class KeyData {
    public Point coordinates; // x, y coordinates of the key
    public Color threshold; // threshold color to press the key
    public int hitKey; // keymap to press
    
    /**
     * initialize private fields with zeros
     * 
     */
    public KeyData() {
        coordinates = new Point(0, 0);
        threshold = new Color(0, 0, 0);
        hitKey = 0;
    }
}
