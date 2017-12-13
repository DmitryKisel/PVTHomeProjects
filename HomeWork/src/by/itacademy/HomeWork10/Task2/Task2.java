package by.itacademy.HomeWork10.Task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static int menuCase = 99;

    public static void main(String[] args) throws IOException {

        String operationNumberStr;

        Map<String,List<Person>> personMap = new HashMap<>();
        List<Person> listMen = new ArrayList<>();
        List<Person> listWomen = new ArrayList<>();

        String man = "man";
        String woman = "woman";

        addMen(listMen);
        addWomen(listWomen);

        personMap.put("woman", listWomen);
        personMap.put("man", listMen );



        do {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Choose person sex");
            System.out.println();
            System.out.println("1. To choose a man - press 1");
            System.out.println();
            System.out.println("2. To choose a woman - press 2");
            System.out.println();
            System.out.println("0. To exit - press 0");


            operationNumberStr = reader.readLine();

            String patternMain = "[0, 1, 2]";
            Pattern pMain = Pattern.compile(patternMain);
            Matcher m1 = pMain.matcher(operationNumberStr);

            if (!m1.matches()) {
                System.out.println("Wrong input format");
                break;
            }

             else {
                menuCase = Integer.parseInt(operationNumberStr);
                switch(menuCase) {
                    case 1:{
                      for(Map.Entry<String, List<Person>> i: personMap.entrySet()){
                            if (i.getKey().equals("man")) {

                                List<Person> newManList = i.getValue();
                                Random random = new Random();
                                int j = random.nextInt(10);
                                System.out.println(newManList.get(j).getLastName() + " " + newManList.get(j).getFirstName() +
                                        " " + newManList.get(j).getPaternalName());
                                System.out.println();

                           }
                      }
                      break;

                        }



                    case 2:{
                        for(Map.Entry<String, List<Person>> i: personMap.entrySet()){
                            if (i.getKey().equals("woman")){
                                List<Person> newList = i.getValue();
                                Random random = new Random();
                                int j = random.nextInt(10);
                                System.out.println(newList.get(j).getLastName() + " " + newList.get(j).getFirstName() +
                                        " " + newList.get(j).getPaternalName());
                                System.out.println();


                            }

                        }
                        break;


                    }

                    case 0:{
                        break;

                    }

                }

            }

        } while (menuCase != 0);




    }

    public static List<Person> addMen(List<Person> list){
        Person person1 = new Person("Петров", "Петр", "Петрович");
        list.add(person1);

        Person person2 = new Person("Иванов", "Петр", "Петрович");
        list.add(person2);

        Person person3 = new Person("Семенов", "Семен", "Петрович");
        list.add(person3);

        Person person4 = new Person("Петров", "Семен", "Петрович");
        list.add(person4);

        Person person5 = new Person("Иванов", "Петр", "Иванович");
        list.add(person5);

        Person person6 = new Person("Старавойтов", "Игорь", "Сергеевич");
        list.add(person6);

        Person person7 = new Person("Нестеров", "Сергей", "Александрович");
        list.add(person7);

        Person person8 = new Person("Равков", "Петр", "Петрович");
        list.add(person8);

        Person person9 = new Person("Смирнов", "Петр", "Петрович");
        list.add(person9);

        Person person10 = new Person("Яковлев", "Петр", "Петрович");
        list.add(person10);

        return list;
    }

    public static List<Person> addWomen(List<Person> list){
        Person person1 = new Person("Петрова", "Ирина", "Сергеевна");
        list.add(person1);

        Person person2 = new Person("Иванова", "Светлана", "Сергеевна");
        list.add(person2);

        Person person3 = new Person("Семенова", "Елена", "Станиславовна");
        list.add(person3);

        Person person4 = new Person("Петрова", "Наталья", "Петровна");
        list.add(person4);

        Person person5 = new Person("Ивановская", "Кристина", "Ивановна");
        list.add(person5);

        Person person6 = new Person("Давидович", "Ольга", "Сергеевна");
        list.add(person6);

        Person person7 = new Person("Нестерва", "Инна", "Александровна");
        list.add(person7);

        Person person8 = new Person("Равкова", "Раиса", "Максимовна");
        list.add(person8);

        Person person9 = new Person("Смирнова", "Наталья", "Петровна");
        list.add(person9);

        Person person10 = new Person("Яковлева", "Светалан", "Сергеевна");
        list.add(person10);

        return list;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
