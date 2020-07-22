package package1;

public class Point {
    public double x1;
    public double x2;

    public Point(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;

    }

    public double distance(Point p2) {


        return Math.sqrt((p2.x2 - p2.x1) * (p2.x2 - p2.x1) + (this.x2 - this.x1) * (this.x2 - this.x1));
    }

}

