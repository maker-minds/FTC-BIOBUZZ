package org.firstinspires.ftc.teamcode.BIOBUZZ.mechanics;

public class CrossSaveSingleton {

    //---Objects---\\
    private static CrossSaveSingleton saveFile = null;

    //---Variables---\\
    public byte storedItems;
    public int x, y;

    //---Functions---\\
    private CrossSaveSingleton() {

    }

    public static CrossSaveSingleton getCrossSaveSingleton() {
        if(saveFile == null) {
            saveFile = new CrossSaveSingleton();
        }
        return saveFile;
    }

    public void saveData(byte storedItems, int x, int y) {
        this.storedItems = storedItems;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public byte getStoredItems() {
        return storedItems;
    }
}
