package HomeWork11;

import HomeWork11.Entity.Root;
import org.xml.sax.SAXException ;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        String link = "http://kiparo.ru/t/test.xml";



        try{

            URL url = new URL(link);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            int responseCode = httpURLConnection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                inputStream = httpURLConnection.getInputStream();
                File file = new File("test.xml");
                fileOutputStream = new FileOutputStream(file);

                int byteRead = -1;
                byte[] buffer = new byte[1024];
                while ((byteRead = inputStream.read(buffer))!=-1){
                    fileOutputStream.write(buffer, 0, byteRead);
                }

                Root root = parseXml(file);
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



    private static Root parseXml(File file) throws ParserConfigurationException,  IOException, SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        SaxParser saxParser = new SaxParser();
        parser.parse(file, saxParser);
        return saxParser.getRoot();
    }
}
