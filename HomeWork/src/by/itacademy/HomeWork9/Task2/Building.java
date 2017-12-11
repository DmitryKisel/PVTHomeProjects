package by.itacademy.HomeWork9.Task2;

import javax.lang.model.util.ElementScanner6;
import java.util.ArrayList;
import java.util.List;

public class Building {
    private  String name;
    private List<Room> rooms;


    public Building(String name) {
        this.name = name;
        rooms = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }


    public void addRoom (String roomName, double square, int windows){
        Room room = new Room(roomName, square, windows);
        rooms.add(room);
    }

    public Room getRoom(String name){
        int count = 0;
        for(int i = 0; i < rooms.size(); i++){
            if (rooms.get(i).getRoomName().equals(name))
                return  rooms.get(i);
            else {
                count++;
            }

        }
        if (count == rooms.size()-1)
            System.out.println("Комната с таким названием не найдена");
        return  null;
    }

    public void describe(Building building){
        System.out.println(building.getName());
        for(int i = 0; i < building.rooms.size(); i++){
            String wind = "";
            System.out.println(" " + building.rooms.get(i).getRoomName() );
            int j = building.rooms.get(i).getWindowsNumber();
            if(j < 11 || j > 19) {
                if (j%10  == 1) {
                    wind = "окно";
                } else if (j%10 == 2 || j%10  == 3 || j%10  == 4) {
                    wind = "окна";
                }

                else wind = "окон";

            }
            else  wind = "окон";

            System.out.print("   Освещенность = " + building.rooms.get(i).getLight() + "(" + building.rooms.get(i).getWindowsNumber()
                    + " " +  wind + " по 700 лк");

            lampDescribe(building.rooms.get(i).getLamps()) ;

            squareDescribe(building.rooms.get(i));

            System.out.println("   Мебель:");
            furnitureDescribe(building.rooms.get(i).getFurniture());
        }
    }

    public void squareDescribe(Room room) {
        if (room.getUsedSquare() == 0) {
            System.out.println("   Площадь = " + room.getSquare() + (" кв.м (свободно 100%)"));
        } else {

            System.out.println("   Площадь = " + room.getSquare() + " кв.м (занято " + room.getUsedSquare() + " кв.м гарантированно свободно " +
                    (room.getSquare() - room.getUsedSquare()) + " кв.м или " + (int) ((room.getUsedSquare() / room.getSquare()) * 100) + "% площади)");
        }
    }


    public void lampDescribe(List <Lamp> lamps){

        if (lamps.isEmpty()) {
            System.out.println(")");
        }
        else {
            for (int i = 0; i < lamps.size(); i++) {

                if (i == lamps.size() - 1)
                    System.out.println("и "+ lamps.get(i).getIllumination() + " лк)");
                else if (i == 0){
                    System.out.print(", лампочки " + lamps.get(i).getIllumination() + " лк, ");
                }
                else {
                    System.out.print(lamps.get(i).getIllumination() + " лк, ");
                }

            }
        }
    }



    public void furnitureDescribe(List<Furniture> furniture){
        if (furniture.isEmpty()) {
            System.out.println("    Мебели нет");
        }

        else {
            for (int i = 0; i < furniture.size(); i++){
                System.out.println("    " + furniture.get(i).getFurnitureName() + " (площадь " + furniture.get(i).getFurnitureSquare() + " кв.м)");
            }
        }
    }




}
