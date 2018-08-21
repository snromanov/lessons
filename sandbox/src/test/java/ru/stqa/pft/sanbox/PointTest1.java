package ru.stqa.pft.sanbox;

import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.Point;

public class PointTest1 {


    @Test

    public void testDoubleDistance () {

      Point p1 = new Point(2, 4);
      Point p2 = new Point(5, 8);


      assert  p1.distance(p2) == 5.0;


    }

  }


