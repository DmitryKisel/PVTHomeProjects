package by.itacademy.HomeWork9.Task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.itacademy.HomeWork9.Task2.Task2.LIGHT_UP_LIMIT;

public class Room {
    private String roomName;
    private  double square;
    private int windowsNumber;

    private int light;
    private int usedSquare;
    private List<Lamp> lamps;
    private List<Furniture> furniture;




    public Room(String roomName, double square, int windowsNumber){
        this.roomName = roomName;
        this.square = square;
        this.windowsNumber = windowsNumber;
        usedSquare = 0;
        light = windowsNumber*700;
        lamps = new ArrayList<>();
        furniture = new ArrayList<>();




    }

    public  void add(Lamp lamp) throws IlluminanceTooMuchException{
        if(lamp.getIllumination() + light > LIGHT_UP_LIMIT) throw new IlluminanceTooMuchException("");
        else {
            light += lamp.getIllumination();
            lamps.add(lamp);
        }

    }

    public  void add(Furniture unit) throws SpaceUsageTooMuchException{
        if (usedSquare >= 0.7*square) throw  new SpaceUsageTooMuchException();
        else {
            usedSquare += unit.getFurnitureSquare();
            furniture.add(unit);
        }

    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public int getWindowsNumber() {
        return windowsNumber;
    }

    public void setWindowsNumber(int windowsNumber) {
        this.windowsNumber = windowsNumber;
    }

    public int getLight() {
        return light;
    }

    public int getUsedSquare() {
        return usedSquare;
    }

    public List<Lamp> getLamps() {
        return lamps;
    }

    public List<Furniture> getFurniture() {
        return furniture;
    }
}


