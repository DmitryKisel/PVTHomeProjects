package by.itacademy.HomeWork12;


import by.itacademy.HomeWork12.Entity.Root;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;


public class Main {

    public static void main(String[] args) {
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        String link = "http://kiparo.ru/t/test.json";



        try{

            URL url = new URL(link);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            int responseCode = httpURLConnection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                inputStream = httpURLConnection.getInputStream();
                File file = new File("test.json");
                fileOutputStream = new FileOutputStream(file);

                int byteRead = -1;
                byte[] buffer = new byte[1024];
                while ((byteRead = inputStream.read(buffer))!=-1){
                    fileOutputStream.write(buffer, 0, byteRead);
                }

                Root root = parseJackson(file);

                System.out.println(root.toString());



            }else{
                System.out.println("Данные не найдены, responseCode = " + responseCode);

            }


        }catch (Exception e){
            System.out.println("Невозможно скачать файл " + e.toString());
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



    private static Root parseJackson(File file) {
        Root root = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));

        try {
            root = mapper.readValue(file, Root.class);
            return root;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }

//    private static String serializeJackson(Root root) {
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            String result = mapper.writeValueAsString(root);
//            return result;
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

}
