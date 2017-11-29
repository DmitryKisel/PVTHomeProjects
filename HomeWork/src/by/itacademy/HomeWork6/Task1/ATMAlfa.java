package by.itacademy.HomeWork6.Task1;

public class ATMAlfa extends ATM implements GetNames{
    private  int loaded20;
    private  int loaded50;
    private  int loaded100;
    private  int balans ;
    private  Main main;

    public ATMAlfa(int loaded20, int loaded50, int loaded100) {
        this.loaded20 = loaded20;
        this.loaded50 = loaded50;
        this.loaded100 = loaded100;
    }



    @Override
    public void getBankName() {
        System.out.println("Альфа-Банк");
        System.out.println();
    }

    @Override
    public  void getATM_ManufactorName() {
        System.out.println("Производитель банкомата: Wincor Nixdorf");
        System.out.println();
    }

    @Override
    public void printBalans(ATMAlfa atm) {
        atm.balans = loaded20*20+ loaded50*50+ loaded100*100;
        System.out.println("Баланс: " + atm.balans);
        System.out.println("бонктноты номиналом 100 - " + atm.loaded100 + " шт.");
        System.out.println("бонктноты номиналом 50 - " + atm.loaded50 + " шт.");
        System.out.println("бонктноты номиналом 20 - " + atm.loaded20 + " шт.");
        System.out.println();



    }

    @Override
    public ATMAlfa calcBonds(int sum, ATMAlfa atm, int n) {
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
                atm = oparationsATM(atm, n*n100, 0, n*n20);

            } else if (sum < 100) {

                System.out.println("бонктноты номиналом 100 - 0 шт.");
                System.out.println("бонктноты номиналом 50 - 0 шт.");
                System.out.println("бонктноты номиналом 20 - " + sum / 20 + " шт.");
                atm = oparationsATM(atm, n*n100, 0, n*(sum/20));

            }
        } else {
            if (sum < 100) {

                if ((sum) >= 50) {
                    n50 = sum / 50;
                    System.out.println("бонктноты номиналом 100 - 0 шт.");
                    System.out.println("бонктноты номиналом 50 - " + n50 + " шт.");
                    n20 = (sum - 50) / 20;
                    if ((sum - 50) % 20 == 0) System.out.println("бонктноты номиналом 20 - " + n20 + " шт.");
                    atm = oparationsATM(atm, 0, n*n50, n*n20);
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
                    atm = oparationsATM(atm, n * n100, n * n50, n * n20);
                }
                else{
                    System.out.println("бонктноты номиналом 100 - " + n100 + " шт.");
                    n50 = (sum - n100 * 100) / 50 ;
                    if (n50 != 0 && (sum - n100 * 100) >= 50)
                        System.out.println("бонктноты номиналом 50 - " + n50 + " шт.");
                    n20 = (sum - n100 * 100 - n50 * 50) / 20;
                    if ((sum - n100 * 100 - n50 * 50) % 20 == 0)
                        System.out.println("бонктноты номиналом 20 - " + n20 + " шт.");
                    atm = oparationsATM(atm, n * n100, n * n50, n * n20);
                }


            }
        }return atm;
    }

    @Override
    public ATMAlfa oparationsATM(ATMAlfa atm, int n100, int n50, int n20) {

        atm.loaded100 = atm.loaded100 + n100;
        atm.loaded50 = atm.loaded50 + n50;
        atm.loaded20 = atm.loaded20 + n20;
        return atm;
    }

    @Override
    public Boolean chekSum(int sum, ATMAlfa atmAlfa) {
         boolean chekATM = false;
        if(atmAlfa.balans != 0 && atmAlfa.balans >= sum) chekATM = true;
        if (sum % 10 == 0 && sum != 10 && sum != 30 && chekATM == true) return true;
        else return false;
    }


}