package ru.stqa.pft.sandbox;

public class Square {
    private final double l;

    public Square(double l) {
        this.l = l;
    }

    public double area() {
        return this.l * this.l;
    }
}
