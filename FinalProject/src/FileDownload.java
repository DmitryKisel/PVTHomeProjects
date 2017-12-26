import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileDownload {
    private static final String LINK1 = "http://kiparo.ru/t/birthdays.json";
    private static final String LINK2 = "http://kiparo.ru/t/birthdays.xml";
    private static  String LINK;
    private static String fileName;

    public  Root download(int downloadChoice){
        if (downloadChoice == 1) {
            LINK = LINK1;
            fileName = "birthdays.json";
        }
        else if (downloadChoice == 2) {
            LINK = LINK2;
            fileName = "birthdays.xml";
        }
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;

        try{

            URL url = new URL(LINK);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            int responseCode = httpURLConnection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                inputStream = httpURLConnection.getInputStream();
                File file = new File(fileName);
                fileOutputStream = new FileOutputStream(file);

                int byteRead = -1 ; // к-во полезных байт в буффере. он может не весь заполняться
                byte[] buffer = new byte[2048];
                while ((byteRead = inputStream.read(buffer))!=-1){
                    fileOutputStream.write(buffer, 0, byteRead);
                }


                if(downloadChoice == 1){
                    JsonParsing jsonParsing = new JsonParsing();
                    return jsonParsing.parseFile(fileName);
                }
                else if(downloadChoice == 2){
                    XmlParsing xmlParsing = new XmlParsing();
                    return  xmlParsing.parseFile(fileName);

                }


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

        return null;
    }
}
