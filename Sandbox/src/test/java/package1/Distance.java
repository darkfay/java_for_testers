package package1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Distance {

    @Test
    public void testDistance() {
        Point p1 = new Point(9,6);
        Point p2 = new Point(12,3);
        Assert.assertEquals(p1.distance(p2), 4.242640687119285);
    }

    @Test
    public void testDistance2() {
        Point p1 = new Point(99,66);
        Point p2 = new Point(122,39);
        Assert.assertEquals(p1.distance(p2), 35.4682957019364);
    }
}
