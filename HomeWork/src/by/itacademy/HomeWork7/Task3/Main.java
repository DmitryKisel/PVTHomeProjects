package by.itacademy.HomeWork7.Task3;
import java.io.*;

public class Main  {
    public static void main(String[] args) throws IOException{
        FileReader fileReader = new FileReader("D:\\!!Дима\\git\\Rep1\\HomeWork\\src\\by\\itacademy\\HomeWork7\\Task3\\ToRead.txt");
        int c;
        System.out.println("Содержимое файла:");
        while((c = fileReader.read())!=-1){
            System.out.print((char)c);
        }
        fileReader.close();


        String toFile;
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        toFile = reader.readLine();

        FileWriter fileWriter = new FileWriter("D:\\!!Дима\\git\\Rep1\\HomeWork\\src\\by\\itacademy\\HomeWork7\\Task3\\ToWrite.txt");
        fileWriter.write(toFile);
        fileWriter.flush();
        System.out.println("Запись в файл успешно осуществлена");
        fileWriter.close();
    }
}
