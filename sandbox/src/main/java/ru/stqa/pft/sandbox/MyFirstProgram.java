package ru.stqa.pft.sandbox;

public class MyFirstProgram {
    //вводим аргументы
    public static void main(String[] args) {
        Point p1 = new Point(2, 4);
        Point p2 = new Point(5, 8);

        System.out.println("Расстояние между  двумя точками p1 и p2 = " + p1.distance(p2));
    }
}
