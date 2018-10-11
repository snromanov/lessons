package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {
        Point p1 = new Point(2, 4);
        Point p2 = new Point(5, 8);

        System.out.println("Расстояние между  двумя точками p1 и p2 = " + p1.distance(p2));




        Square s = new Square(5);
        s.l = 5;
        System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());


        Rectangle r = new Rectangle(4,6);
        r.a = 4;
        r.b = 6;
        System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

    }
}
