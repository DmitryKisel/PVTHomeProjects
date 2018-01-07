package by.itacademy.Lesson13.AbstrCls;

public class Main {
    public static void main(String[] args) {
        makeSmth(new AbstractClass() {
            @Override
            public void test() {

            }
        });
        AbstractClass a = new AbstractClass() {
            @Override
            public void test() {
            }
        };
        makeSmth(a);

        }

        public static void makeSmth(AbstractClass obj){
        obj.test();
        }
    }



