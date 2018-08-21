package ru.stqa.pft.sanbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.Point;

import java.awt.geom.Area;

public class PointTest2 {

  @Test

public void testDoubleDistance () {

  Point p1 = new Point(2, 4);
  Point p2 = new Point(5, 8);


  Assert.assertEquals(p1.distance(p2), 5.0);


}

}
