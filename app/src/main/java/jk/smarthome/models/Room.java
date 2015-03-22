package jk.smarthome.models;

import java.util.HashMap;

/**
 * Created by jacek on 02-12-2014.
 */
public class Room {

    private int id;
    private String name;
    private int humidity;
    private int temperature;
    private int lighting; //0-off, 1-ceiling light only, 2-wall light only, 3-all light, 4-dim light ceiling, 5-dim wall light
    private int presence; //0-nobody, 1-J, 2-W, 3-Kid
    private int cameras; //0-not recording 1-await movement and record

    private boolean openDoor;
    private int openDoor1; //0-Door shut and locked 1-Door shut, not locked 2-Door open
    private boolean openWindow;
    private int openWindow1; //0-Windows shut, 1-Window ajar, 2-Window open
    private boolean hasCloset;

    private boolean brokenInto; // false-do nothing, true-display alert
    private boolean fireDetected; // false-do nothing, true-display alert
    private boolean carbonMonoxideDetected;// false-do nothing, true-display alert
    private boolean floodDetected;// false-do nothing, true-display alert
    private boolean movementDetected;// false-camera standby, true-if setting 'away'-start recording

    private boolean openTap; //false-tap closed, true-tap open, display alert
    private int bathTub; //0-off, 1-filling, 2-full
    private int washingMachine;

    private int oven;
    private int dishwasher;
    private int refrigerator;

    private HashMap<String, String> appliances= new HashMap<>(); // key = name of appliance, value mode

    public Room(int id, String name, int humidity, int temperature, int lighting, int presence, int cameras,

                boolean hasCloset, boolean openDoor, boolean openWindow,

                boolean brokenInto, boolean fireDetected, boolean carbonMonoxideDetected, boolean floodDetected, boolean movementDetected,

                boolean openTap, int bathTub, int washingMachine,

                int oven, int dishwasher, int refrigerator,

                int openDoor1, int openWindow1) {

        this.id = id;
        this.name = name;
        this.brokenInto = brokenInto;
        this.carbonMonoxideDetected = carbonMonoxideDetected;
        this.floodDetected = floodDetected;
        this.temperature = temperature;
        this.fireDetected = fireDetected;
        this.humidity = humidity;
        this.movementDetected = movementDetected;
        this.cameras = cameras;
        this.lighting = lighting;
        this.openTap = openTap;
        this.bathTub = bathTub;
        this.washingMachine = washingMachine;
        this.oven = oven;

        this.dishwasher = dishwasher;
        this.refrigerator= refrigerator;
        this.presence = presence;

        this.hasCloset = hasCloset;

        this.openDoor = openDoor;
        this.openWindow = openWindow;
        this.openDoor1 = openDoor1;
        this.openWindow1 = openWindow1;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getLighting() {
        return lighting;
    }

    public void setLighting(int lighting) {
        this.lighting = lighting;
    }

    public int getPresence() {
        return presence;
    }

    public void setPresence(int presence) {
        this.presence = presence;
    }

    public int getCameras() {
        return cameras;
    }

    public void setCameras(int cameras) {
        this.cameras = cameras;
    }

    public boolean isHasCloset() {
        return hasCloset;
    }

    public void setHasCloset(boolean hasCloset) {
        this.hasCloset = hasCloset;
    }

    public boolean isBrokenInto() {
        return brokenInto;
    }

    public void setBrokenInto(boolean brokenInto) {
        this.brokenInto = brokenInto;
    }

    public boolean isFireDetected() {
        return fireDetected;
    }

    public void setFireDetected(boolean fireDetected) {
        this.fireDetected = fireDetected;
    }

    public boolean isCarbonMonoxideDetected() {
        return carbonMonoxideDetected;
    }

    public void setCarbonMonoxideDetected(boolean carbonMonoxideDetected) {
        this.carbonMonoxideDetected = carbonMonoxideDetected;
    }

    public boolean isFloodDetected() {
        return floodDetected;
    }

    public void setFloodDetected(boolean floodDetected) {
        this.floodDetected = floodDetected;
    }

    public boolean isMovementDetected() {
        return movementDetected;
    }

    public void setMovementDetected(boolean movementDetected) {
        this.movementDetected = movementDetected;
    }

    public boolean isOpenTap() {
        return openTap;
    }

    public void setOpenTap(boolean openTap) {
        this.openTap = openTap;
    }

    public int getBathTub() {
        return bathTub;
    }

    public void setBathTub(int bathTub) {
        this.bathTub = bathTub;
    }

    public int getWashingMachine() {
        return washingMachine;
    }

    public void setWashingMachine(int washingMachine) {
        this.washingMachine = washingMachine;
    }

    public int getOven() {
        return oven;
    }

    public void setOven(int oven) {
        this.oven = oven;
    }

    public int getDishwasher() {
        return dishwasher;
    }

    public void setDishwasher(int dishwasher) {
        this.dishwasher = dishwasher;
    }

    public int getRefrigerator() {
        return refrigerator;
    }

    public void setRefrigerator(int refrigerator) {
        this.refrigerator = refrigerator;
    }


    public boolean isOpenDoor() {
        return openDoor;
    }

    public void setOpenDoor(boolean openDoor) {
        this.openDoor = openDoor;
    }

    public boolean isOpenWindow() {
        return openWindow;
    }

    public void setOpenWindow(boolean openWindow) {
        this.openWindow = openWindow;
    }

    public int getOpenDoor1() {
        return openDoor1;
    }

    public void setOpenDoor1(int openDoor1) {
        this.openDoor1 = openDoor1;
    }

    public int getOpenWindow1() {
        return openWindow1;
    }

    public void setOpenWindow1(int openWindow1) {
        this.openWindow1 = openWindow1;
    }

    public HashMap<String, String> getAppliances() {
        return appliances;
    }

    public void setAppliances(HashMap<String, String> appliances) {
        this.appliances = appliances;
    }
}
