package ru.stqa.pft.sandbox;

public class Point {

    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point p2) {
        double dx = this.x - p2.x; // по формуле x2-x1
        double dy = this.y - p2.y; // по формуле y2-y1
        return Math.sqrt(dx * dx + dy * dy); // выводим  квадратный корень


    }

}

