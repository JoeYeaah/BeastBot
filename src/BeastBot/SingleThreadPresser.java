package BeastBot;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * tries to detect color changes and emulate keyboard strokes
 *
 * @author Joe Ye
 */
public class SingleThreadPresser implements Runnable {

    /**
     * initialize private fields
     * 
     * @param keyData information about the key to press
     */
    public SingleThreadPresser(KeyData keyData) {
        this.keyData = keyData;
        lastPress = 0;

        try {
            robot = new Robot();
        } catch (AWTException ex) {
            Logger.getLogger(SingleThreadPresser.class.getName()).log(Level.SEVERE, null, ex);
        }

        keepRunning = new AtomicBoolean(true);
    }

    /**
     * stops detecting key colors and pressing
     *
     */
    public void stop() {
        keepRunning.set(false);
    }

    /**
     * Runnable implementation
     * 
     */
    @Override
    public void run() {
        while (keepRunning.get()) {
            Color coordinatesColor = robot.getPixelColor(keyData.coordinates.x, keyData.coordinates.y);
            if (coordinatesColor.getRed() > keyData.threshold.getRed()
                    && coordinatesColor.getGreen() < keyData.threshold.getGreen()
                    && coordinatesColor.getBlue() < keyData.threshold.getBlue()
                    && (System.currentTimeMillis() - lastPress) > PRESSLENGTH) {
                robot.keyPress(keyData.hitKey);
                robot.keyRelease(keyData.hitKey);
                lastPress = System.currentTimeMillis();
            }
          try {
            Thread.sleep(10);
          } catch (InterruptedException ex) {
            Logger.getLogger(SingleThreadPresser.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
    }

    private static final long PRESSLENGTH = 70; // delay to prevent multiple clicks in a short period of time
    private long lastPress; // last time it presses the key in millisecons
    private KeyData keyData; // information about the key
    private Robot robot; // my little robot

    private AtomicBoolean keepRunning; // determine of keeps trying to press the key
}
