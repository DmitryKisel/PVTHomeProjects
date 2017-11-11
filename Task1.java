import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
Задача1.
Условие:
1.  Создайте переменную типа String c любым текстом (не сильно короткое).
(Осуществляется путем ввода с консоли).
2. Далее выведите на экран количество символов в данной строке.
3. Далее разделите строку пополам (если ровно поделить не выходит то +-1 не страшно),
в результате у вас должно быть 2-е новых переменных типа String с частями из изначальной
строки. Полученные строки выведите на экран.

 */
public class Task1 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        int l = text.length();
        System.out.println("Количество символов в строке: " + l);
        String textPart1;
        String textPart2;
        if (l%2 == 0)
            {textPart1 = text.substring(0,(l/2));
            textPart2  = text.substring(l/2, l);}
        else
            {textPart1 = text.substring(0,(l/2)+1);
            textPart2  = text.substring((l/2)+1, l);}
        System.out.println(textPart1);
        System.out.println(textPart2);
    }
}
