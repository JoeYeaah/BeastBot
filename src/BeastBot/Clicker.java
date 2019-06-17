package BeastBot;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Does the clicking stuff
 *
 * @author Joe Yeah
 */
public class Clicker implements Runnable {

    public Clicker(KeysData keysData) {
        this.keysData = keysData;
        keepRunning = new AtomicBoolean(true);
    }

    public void stop() {
        keepRunning.set(false);
    }

    @Override
    public void run() {
        while (keepRunning.get()) {
            for (int i = 0; i < keysData.keyN; i++) {
                keysData.keyColors[i] = keysData.getPixelColor(keysData.buttonCoords[i].x, keysData.buttonCoords[i].y);
                keysData.pressKey(i);
            }
        }
    }

    private KeysData keysData;
    private AtomicBoolean keepRunning;
}
