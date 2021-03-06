package by.itacademy.HomeWork6.Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main  {
    public static int menuCase = 99;
    public static void main(String[] args) throws IOException {
        int loaded20 = 200;
        int loaded50 = 30;
        int loaded100 = 100;

        ATMAlfa atmAlfa = new ATMAlfa(loaded20, loaded50, loaded100);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("Вас приветствтует программа Банкомат");
            System.out.println("Выберите операцию");
            System.out.println("1. Добавление денег");
            System.out.println("2. Снятие денег");
            System.out.println("3. Количество денег в банкомате");
            System.out.println("4. Узнать название банка");
            System.out.println("5. Узнать производителя банкомата");
            System.out.println("0. Выход из программы");
            menuCase = Integer.parseInt(reader.readLine());


            switch (menuCase) {
                case 1: {
                    System.out.println("Введите сумму которую вы хотите добавить");
                    int sum = Integer.parseInt(reader.readLine());
                    if (atmAlfa.chekSum(sum, atmAlfa).equals(true)) {
                        atmAlfa.calcBonds(sum, atmAlfa, 1);
                        System.out.println("Операция удалась");
                        menuCase = 99;
                        break;
                    } else {
                        System.out.println("Операция не удалась");
                        menuCase = 99;
                        break;
                    }

                }
                case 2: {
                    System.out.println("Введите сумму которую вы хотите снять");
                    int sum = Integer.parseInt(reader.readLine());
                    if (atmAlfa.chekSum(sum, atmAlfa).equals(true)) {
                        atmAlfa.calcBonds(sum,atmAlfa, -1);
                        System.out.println("Операция удалась");
                        menuCase = 99;
                        break;
                    } else {
                        System.out.println("Операция не удалась");
                        menuCase = 99;
                        break;
                    }
                }
                case 3: {
                    atmAlfa.printBalans(atmAlfa);
                    menuCase = 99;
                    break;
                }

                case 4: {
                    atmAlfa.getBankName();
                    menuCase = 99;
                    break;
                }

                case 5: {
                    atmAlfa.getATM_ManufactorName();
                    menuCase = 99;
                    break;
                }

            }
        }while (menuCase !=0);
    }


}