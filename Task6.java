import java.io.*;


public class Task6 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите x");
        String sx = reader.readLine();
        System.out.println("Введите t");
        String st = reader.readLine();
        System.out.println("Введите s");
        String ss = reader.readLine();
        double x = Double.parseDouble(sx);
        double t = Double.parseDouble(st);
        double s = Double.parseDouble(ss);

        double xt = Math.pow(x, t);
        double xs = Math.pow(x, s);
        double numerator = Math.pow(Math.sin(xt), 2);
        double consequent = Math.sqrt(1 + xs);
        double y = numerator / consequent;

        System.out.println("y равен:" + y);


    }
}
