package ru.stqa.pft.sandbox;

public class Point {
  double x, y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }


  public double getX() {
    return x;
  }

  public  double getY() {
    return y;
  }

    //Вводим функцию
    public static double distance(Point p1, Point p2) {
      double dx = p1.x - p2.x; // по формуле x2-x1
      double dy = p1.y - p2.y; // по формуле y2-y1
      return Math.sqrt(dx * dx + dy * dy); //квадратный корень



  }

}

