import  java.io.*;
public class HW2Task4 {
    /*
   ДЗ2 Задача 4.
   Условие: Написать программу, определяющую, образуют ли цифры некоторого числа строго возрастающую последовательность.
   Например: 123 – образуют, 212 – не образуют.

     */
    public static void main(String[] args) throws IOException{

        // Inputting number
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String number = reader.readLine();

        //Divide number for digits
        char[] charArray = number.toCharArray();


        // Converting char array to integer array
        int[] array = new int[charArray.length];

        for (int i = 0; i < charArray.length; i++){
            array[i] = Integer.parseInt(Character.toString(charArray[i]));
        }

        //check for growing up sequence
       int count = 0;
           for (int i = 0; i < array.length - 1; i++) {

               if (array[i + 1] != array[i] + 1) {
                   System.out.println("Number does not form growing up sequence");
                   break;
               } else count++;
           }

           if (count == array.length -1)
           System.out.println("Number forms growing up sequence");



    }
}
