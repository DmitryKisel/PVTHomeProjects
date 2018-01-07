package by.itacademy.Lesson13;

public class SolutionWithXORbits {


    public static void main(String[] args) {
        int [] array = {1, 2, 3, 1, 2, 3, 5, 8, 8};
        System.out.println(getNumber(array));
    }
    public static int getNumber(int[] array){
        int result = 0;
        for(int i = 0; i < array.length; i++){
            result = result ^ array[i];
        }
        return result;
    }
}
