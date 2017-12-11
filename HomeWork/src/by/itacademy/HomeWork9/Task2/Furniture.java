package by.itacademy.HomeWork9.Task2;

public class Furniture {
    private String furnitureName;
    private  double furnitureSquare;

    public Furniture(String furnitureName, double furnitureSquare) {
        this.furnitureName = furnitureName;
        this.furnitureSquare = furnitureSquare;
    }

    public String getFurnitureName() {
        return furnitureName;
    }

    public void setFurnitureName(String furnitureName) {
        this.furnitureName = furnitureName;
    }

    public double getFurnitureSquare() {
        return furnitureSquare;
    }

    public void setFurnitureSquare(double furnitureSquare) {
        this.furnitureSquare = furnitureSquare;
    }

    public void describe() {
        System.out.println(String.format("          %s (площадь = %d м2)", furnitureName, furnitureSquare));
    }
}
