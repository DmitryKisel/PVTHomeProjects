package by.itacademy.Lesson13;

public class Main {

    public static void main(String[] args) {
        int money = getMoney1(); // 1 variant OLD
        getMoney(new OneGetMoneyListner() {
            @Override
            public void onMoney(int money) {
                System.out.println(money);
            }
    });                             // 2 var with anonimous class
    }
    public static int getMoney1(){
        return 50;
    }

    public static void getMoney(OneGetMoneyListner listner){
        listner.onMoney(50);
    }

    interface  OneGetMoneyListner{
        void onMoney(int money);
    }
}
