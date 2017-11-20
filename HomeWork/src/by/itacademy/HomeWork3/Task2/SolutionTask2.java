package by.itacademy.HomeWork3.Task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class SolutionTask2 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("input number of the news");
        int newsNumber = Integer.parseInt(reader.readLine());
        reader.close();
        System.out.println("You need " + getPageNumber(newsNumber) + " pages for location of the " + newsNumber + " news");
            }

    /**
     * This method rounds incoming number upward
     * example: x = roundUp(1.1); after rounding x == 2
     * @param number  incoming number
     * @return number, which was rounded upward
     */
    public  static  int getRoundUp(double number){
        int numberRoundUp = new BigDecimal(number).setScale(0, RoundingMode.UP).intValue();
        return numberRoundUp;
    }

    /**
     * This method returns the number of pages required for location N news
     * @param newsNumber incoming number of news
     * @return number of pages
     */
    public static int getPageNumber(int newsNumber){

        int pageNumber = getRoundUp((double)newsNumber/10);
        return  pageNumber;
    }
}
