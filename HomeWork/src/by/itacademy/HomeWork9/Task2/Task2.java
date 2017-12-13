package by.itacademy.HomeWork9.Task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task2 {
    public static String exitCase = "Y";
    public static int menuCase = 99;
    public static  final  int LIGHT_UP_LIMIT = 7000;
    public static  final  int LIGHT_DOWN_LIMIT = 300;

    public static void main(String[] args) throws IOException, NullPointerException,
                                                  SpaceUsageTooMuchException, IlluminanceTooMuchException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String buildingName;
        int roomsNumber;

        do{
            System.out.println("Вы хотите созда новое здание? Если да - нажмите любую клавишу и ввод, если нет - N и ввод");
            line = reader.readLine();

            if(line.equalsIgnoreCase("N"))  {
                exitCase = "N";
                break;}

            else{
                System.out.println("Введите название здания");
                buildingName = reader.readLine();
                Building  building =  new Building(buildingName);

                System.out.println("Введите количество комнат, которое выхотите добавить");
                roomsNumber = Integer.parseInt(reader.readLine());
                if (roomsNumber <= 0) break;
                else {
                    for (int i = 1; i <= roomsNumber; i++) {
                        String adding;
                        String roomName;
                        double square;
                        int windowsNumber;

                        if (i % 10 == 3) adding = "-ей";
                        else adding = "-ой";

                        System.out.println("Введите название " + i + adding + " комнаты");
                        roomName = reader.readLine();

                        System.out.println("Введите площадь " + i + adding + " комнаты");
                        square = Double.parseDouble(reader.readLine());

                        System.out.println("Введите количество окон в " + i + adding + " комнате");
                        windowsNumber = Integer.parseInt(reader.readLine());

                        building.addRoom(roomName, square, windowsNumber);
                    }
                }

                do {
                    System.out.println("1. Для добавления источника света в комнате введите 1");
                    System.out.println("2. Для добавления мебели в комнату введите 2");
                    System.out.println("3. Для Вывода информации о здании введите 3");
                    System.out.println("0. Для выхода из меню введите 0");

                    menuCase = Integer.parseInt(reader.readLine());

                    switch (menuCase){
                        case 1: {
                            String roomName;
                            int light;

                            System.out.println("Введите название комнаты в которой вы хотите повысить уровень освещенности");
                            roomName = reader.readLine();

                            try {
                                if (building.getRoom(roomName).equals(null)) {
                                    System.out.println("Комната с таким названием не найдена");
                                }
                            } catch (NullPointerException e){

                                break;
                            }


                            System.out.println("В настоящее время освещенность в комнате \"" +roomName +"\" равна " + building.getRoom(roomName).getLight());
                            if (building.getRoom(roomName).getLight() > LIGHT_UP_LIMIT ) throw new IlluminanceTooMuchException ("Предел освещения в комнате превышен");

                            else {
                                do {
                                    System.out.println("1. Для добавление источника света нажмите 1 ");
                                    System.out.println("0. Для выхода нажмите 0 ");
                                    menuCase = Integer.parseInt(reader.readLine())+10;
                                    switch (menuCase){
                                        case 11:{

                                            try {

                                                System.out.println("Введите освещенность источника света в люксах");
                                                light = Integer.parseInt(reader.readLine());
                                                 Lamp lamp = new Lamp(light);
                                                 building.getRoom(roomName).add(lamp);
                                                 break;

                                            } catch (IlluminanceTooMuchException e){
                                                System.out.println("Предел освещенности превышен, освещенность в комнате составляет " + building.getRoom(roomName).getLight()
                                                                    + " люкс, максимальное значение " + LIGHT_UP_LIMIT + " люкс");
                                                break;
                                            }


                                        }

                                        case 10: {
                                            menuCase = 0;
                                            break;
                                        }

                                        default: {
                                            System.out.println("Вы ввели не верное значение");
                                            menuCase = 99;
                                        }
                                    }

                                } while (menuCase != 0);

                            }
                            menuCase = 99;
                            break;

                        }

                        case 2:{


                            String roomName;
                            double furnitureSquare;
                            String furnitureName;


                            System.out.println("Введите название комнаты в которую вы хотите добавить мебель");
                            roomName = reader.readLine();

                            try {
                                if (building.getRoom(roomName).equals(null)) {
                                    System.out.println("Комната с таким названием не найдена");
                                }
                            } catch (NullPointerException e){

                                break;
                            }


                            System.out.println("В настоящее время в комнате \"" +roomName +"\" площадью " + building.getRoom(roomName).getSquare() + "кв.м,  занято " + building.getRoom(roomName).getUsedSquare() + " кв.м");
                            if (building.getRoom(roomName).getUsedSquare() >= 0.7*building.getRoom(roomName).getSquare())  throw  new SpaceUsageTooMuchException();

                            else {
                                do {
                                    System.out.println("1. Для добавление предмета мебели нажмите 1 ");
                                    System.out.println("0. Для выхода нажмите 0 ");
                                    menuCase = Integer.parseInt(reader.readLine())+20;
                                    switch (menuCase){
                                        case 21:{

                                            try {

                                                System.out.println("Введите название предмета мебели");
                                                furnitureName = reader.readLine();
                                                System.out.println("Введите занимаемую им площадь");
                                                furnitureSquare = Double.parseDouble(reader.readLine());
                                                if(building.getRoom(roomName).getUsedSquare() + furnitureSquare >= 0.7*building.getRoom(roomName).getSquare()){
                                                    System.out.println("В комнает недостаточно свободного места");
                                                    break;
                                                }
                                                else {
                                                    Furniture furnitureUnit = new Furniture(furnitureName,furnitureSquare);
                                                    building.getRoom(roomName).add(furnitureUnit);
                                                    break;
                                                }

                                            } catch (SpaceUsageTooMuchException e){
                                                System.out.println("В комнате нет свободного места, используемая площадь ь в комнате составляет " + building.getRoom(roomName).getUsedSquare()
                                                        + " кв.м, общая площадь комнаты " + building.getRoom(roomName).getSquare() + " кв.м");
                                                break;
                                            }


                                        }

                                        case 20: {
                                            menuCase = 0;
                                            break;
                                        }

                                        default: {
                                            System.out.println("Вы ввели не верное значение");
                                            menuCase = 99;
                                        }
                                    }

                                } while (menuCase != 0);

                            }
                            menuCase = 99;
                            break;


                        }

                        case 3:{

                            building.describe(building);

                        }

                        case 0:{
                            break;
                        }

                        default: {
                            System.out.println("Вы ввели не верное значение");
                            menuCase = 99;
                        }
                    }
                }while (menuCase != 0);


            }

        }while (exitCase != "N");

    }


}
