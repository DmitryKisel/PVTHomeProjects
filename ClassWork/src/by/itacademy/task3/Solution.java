package by.itacademy.task3;

public class Solution {
    public static void main(String[] args) {
    double res1 = triangle(5,2);
        System.out.println("triangle" + res1);
        double res2 = square(6);
        System.out.println("square" + res2);

        double res3 = rectangle(12, 4);
        System.out.println("rectangle" + res3);
    }

    /**
     * This method returns a triangle area;
     * @param side1 - side of triangle
     * @param height - height to side a
     * @return
     */
    public static double triangle(double side1, double height){
        return 0.5*side1*height;
    }

    /**
     * This method returns a circle area
     * @param radius - radius of circle
     * @return
     */
    public static Double circle(double radius){
        return Math.PI*radius;
    }

    /**
     * This method returns a square area;
     * @param side - side of square
     * @return
     */
    public static Double square(double side){
        return side*side;
    }

    /**
     * This method returns a rectangle area;
     * @param side1, side2 - sides of rectangle
     * @return
     */
    public static Double rectangle (double side1, double side2){
        return side1*side2;
    }
}
