package by.itacademy.HomeWork5.Task2;

public class Manager {

    /**
     * This method determines possibility of cash withdrawal or adding funds
     *
     * @param sum
     * @return
     */
    public static Boolean chekSum(int sum) {

        if (sum % 10 == 0 && sum != 10 && sum != 30) return true;
        else return false;
    }


    /**
     * This method determines number of bonds for operation of cash withdrawal or adding funds
     *
     * @param sum
     */
    public static ATM calcBonds(int sum, ATM atm, int n) {
        int n100 = sum / 100;
        int n50;
        int n20;
        if (sum % 20 == 0) {
            n100 = sum / 100;
            if (n100 != 0 && sum >= 100) {
                System.out.println("бонктноты номиналом 100 - " + n100 + " шт.");
                System.out.println("бонктноты номиналом 50 - 0 шт.");
                n20 = (sum - n100 * 100) / 20;
                System.out.println("бонктноты номиналом 20 - " + n20 + " шт.");
                atm = addATM(atm, n*n100, 0, n*n20);

            } else if (sum < 100) {

                System.out.println("бонктноты номиналом 100 - 0 шт.");
                System.out.println("бонктноты номиналом 50 - 0 шт.");
                System.out.println("бонктноты номиналом 20 - " + sum / 20 + " шт.");
                atm = addATM(atm, n*n100, 0, n*(sum/20));

            }
        } else {
            if (sum < 100) {

                if ((sum) >= 50) {
                    n50 = sum / 50;
                    System.out.println("бонктноты номиналом 100 - 0 шт.");
                    System.out.println("бонктноты номиналом 50 - " + n50 + " шт.");
                    n20 = (sum - 50) / 20;
                    if ((sum - 50) % 20 == 0) System.out.println("бонктноты номиналом 20 - " + n20 + " шт.");
                    atm = addATM(atm, 0, n*n50, n*n20);
                }


            } else {
                if(sum%100 < 50) {
                    n100 = n100 - 1;
                    System.out.println("бонктноты номиналом 100 - " + n100 + " шт.");
                    n50 = (sum - n100 * 100) / 50 - 1;
                    if (n50 != 0 && (sum - n100 * 100) >= 50)
                        System.out.println("бонктноты номиналом 50 - " + n50 + " шт.");
                    n20 = (sum - n100 * 100 - n50 * 50) / 20;
                    if ((sum - n100 * 100 - n50 * 50) % 20 == 0)
                        System.out.println("бонктноты номиналом 20 - " + n20 + " шт.");
                    atm = addATM(atm, n * n100, n * n50, n * n20);
                }
                else{
                    System.out.println("бонктноты номиналом 100 - " + n100 + " шт.");
                    n50 = (sum - n100 * 100) / 50 ;
                    if (n50 != 0 && (sum - n100 * 100) >= 50)
                        System.out.println("бонктноты номиналом 50 - " + n50 + " шт.");
                    n20 = (sum - n100 * 100 - n50 * 50) / 20;
                    if ((sum - n100 * 100 - n50 * 50) % 20 == 0)
                        System.out.println("бонктноты номиналом 20 - " + n20 + " шт.");
                    atm = addATM(atm, n * n100, n * n50, n * n20);
                }


            }
        }return atm;
    }

    /**
     * This method adds or removes bonds from ATM
     * @param atm
     * @param n100 number of 100 denomination bonds
     * @param n50 number of 50 denomination bonds
     * @param n20 number of 20 denomination bonds
     * @return
     */
    public static ATM addATM(ATM atm, int n100, int n50, int n20){
        atm.loaded100 = atm.loaded100 + n100;
        atm.loaded50 = atm.loaded50 + n50;
        atm.loaded20 = atm.loaded20 + n20;
        return atm;
    }
}
