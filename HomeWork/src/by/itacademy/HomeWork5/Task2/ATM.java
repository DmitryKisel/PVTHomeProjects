package by.itacademy.HomeWork5.Task2;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ATM {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Вас приветствтует программа Банкомат");
        System.out.println("Выберите операцию");
        System.out.println("1. Добавление денег");
        System.out.println("2. Снятие денег");
        int choice = Integer.parseInt(reader.readLine());
        switch (choice){
            case 1: {
                System.out.println("Введите сумму которую вы хотите добавить");
                int sum = Integer.parseInt(reader.readLine());
                if (chekSum(sum).equals(true)) {
                    printSum(sum);
                    System.out.println("Операция удалась");
                    break;
                }
                else {
                    System.out.println("Операция не удалась");
                    break;}
                }
            case 2: {
                System.out.println("Введите сумму которую вы хотите снять");
                int sum = Integer.parseInt(reader.readLine());
                if (chekSum(sum).equals(true)) {
                    printSum(sum);
                    System.out.println("Операция удалась");
                    break;
                }
                else {
                    System.out.println("Операция не удалась");
                    break;}
            }
            }
        }


    /**
     * This method determines possibility of cash withdrawal or adding funds
     * @param sum
     * @return
     */
    public static Boolean chekSum (int sum){
        int rest100 = sum%100;
        if(rest100==0 ) return true;
        else{
            int rest50 = (rest100)%50;
            if (rest50 == 0) return true;
            else {
                int rest20 = (rest50) % 20;
                if (rest20 == 0) return true;
                else return false;
            }
        }
    }

    /**
     * This method determines number of bonds for operation of cash withdrawal or adding funds
     * @param sum
     */
    public static void printSum (int sum){
        int n100 = sum/100;
        if(n100 != 0 && sum >= 100) System.out.println("бонктноты номиналом 100 - " + n100 + " шт.");
        int n50 = (sum - n100*100)/50;
        if (n50 != 0 && (sum - n100*100) >= 50) System.out.println("бонктноты номиналом 50 - " + n50 + " шт.");
        int n20 = (sum - n100*100 - n50*50) / 20;
        if (n20 != 0) System.out.println("бонктноты номиналом 20 - " + n20 + " шт.");

    }
}
