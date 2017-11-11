import java.io.*;

/*
Задача 3.
Условие:
Имеется прямоугольное отверстие размерами a и b (размеры задать любые),
определить, можно ли его полностью закрыть круглой картонкой
радиусом r (тоже подставляем любое значение).
 */
public class Task3  {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите a");
        String sa = reader.readLine();
        System.out.println("Введите b");
        String sb = reader.readLine();
        System.out.println("Введите r");
        String sr = reader.readLine();
        int a = Integer.parseInt(sa);
        int b = Integer.parseInt(sb);
        int r = Integer.parseInt(sr);
        double c =  Math.sqrt((a/2)*(a/2) + (b/2)*(b/2));
        if (r < c) System.out.println("Отверстие с размерами a на b нельзя закрыть кругом радиусом r");
        else System.out.println("Отверстие с размерами a на b можно закрыть кругом радиусом r");
    }
}
