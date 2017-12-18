package by.itacademy.Lesson11.Task1;



import by.itacademy.Lesson11.Task1.Entity.People;
import by.itacademy.Lesson11.Task1.Entity.Root;
import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String LINK = "http://kiparo.ru/t/test.json";
    public static void main(String [] args){

        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;

        try{

            URL url = new URL(LINK);
            HttpURLConnection httpURLConnection =
                    (HttpURLConnection)url.openConnection();
            int responseCode = httpURLConnection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                inputStream = httpURLConnection.getInputStream();
                File file = new File("test.json");
                fileOutputStream = new FileOutputStream(file);

                int byteRead = -1; // к-во полезных байт в буффере. он может не весь заполняться
                byte[] buffer = new byte[2048];
                while ((byteRead = inputStream.read(buffer))!=-1){
                    fileOutputStream.write(buffer, 0, byteRead);
                }

                //parseJson();
                parseGson();

            }else{
                System.out.println("Данные не найдены, responseCode = " + responseCode);
            }


        }catch (Exception e){
            System.out.println("Невозможно скачать файл");
        }finally {
            if(inputStream != null){
                try{
                    inputStream.close();
                }catch (IOException e){
                    System.out.println(e.getMessage());
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }

    public static void parseJson() {
        JSONParser parser = new JSONParser();
        FileReader fileReader = null;
        try{
            Root rootModel = new Root();
            fileReader = new FileReader("test.json");
            JSONObject root = (JSONObject) parser.parse(fileReader);
            String name = (String) root.get("name");
            System.out.println("name = " + name);
            rootModel.setName(name);

            JSONArray peoples = (JSONArray) root.get("people");
            List<People> peopleList = new ArrayList<>();
            for (Object element: peoples){
                People peopleModel = new People();
                JSONObject people = (JSONObject) element;

                long id = (Long) people.get("id");
                System.out.println("id = " + id);
                peopleModel.setId((int)id);

                String nameP = (String)people.get("name");
                System.out.println("name = " + nameP);
                peopleModel.setName(nameP);

                String surname = (String)people.get("surname");
                System.out.println("surname = " + surname);
                peopleModel.setSurname(surname);

                long age = (Long) people.get("age");
                System.out.println("age = " + age);
                peopleModel.setAge((int)age);

                boolean isDegree = (Boolean)people.get("isDegree");
                System.out.println("isDegree = " + isDegree);
                peopleModel.setDegree(isDegree);

                System.out.println("--------------");

                peopleList.add(peopleModel);
            }

            rootModel.setPeople(peopleList);
            System.out.println("=============================================================");
            System.out.println(root.toString());


        }catch (Exception e){
            System.out.println("Невозможно открыть json error = " + e.toString());
        }
        finally {
            if(fileReader != null ){
                try {
                    fileReader.close();
                } catch (Exception e){
                    System.out.println("Невозможно закрыть fileReader errror = " + e.toString());
                }
            }
        }

    }

    private  static  void parseGson(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("test.json"));
            Gson gson = new Gson();
            Root root = gson.fromJson(reader, Root.class);
            System.out.println(root.toString());

        }catch (Exception e){
            System.out.println("Невозможно открыть json error = " + e.toString());
        }

    }

}