package by.itacademy.HomeWork5.Task2;

public   class ATM {
    int loaded20;
    int loaded50;
    int loaded100;

    public ATM(int loaded20, int loaded50, int loaded100) {
        this.loaded20 = loaded20;
        this.loaded50 = loaded50;
        this.loaded100 = loaded100;
    }

    /**
     * This method prints quantity of bonds in ATM
     * @param atm
     */
    public static void printLoad (ATM atm){
        System.out.println("бонктноты номиналом 100 - " + atm.loaded100 + " шт.");
        System.out.println("бонктноты номиналом 50 - " + atm.loaded50 + " шт.");
        System.out.println("бонктноты номиналом 20 - " + atm.loaded20 + " шт.");
        System.out.println();
    }
}