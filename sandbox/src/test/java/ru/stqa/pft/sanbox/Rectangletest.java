package ru.stqa.pft.sanbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.Rectangle;

public class Rectangletest {

  @Test

  public void testRectangle () {
    Rectangle r = new Rectangle(4,6);
    r.a = 4;
    r.b = 6;

    Assert.assertEquals (r.area(), 24.0);

  }
}
