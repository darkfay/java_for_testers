package package1;

public class Distance {
//    public static double distance(Point p1, Point p2) {
//
//
//        return Math.sqrt((p2.x2 - p2.x1) * (p2.x2 - p2.x1) + (p1.x2 - p1.x1) * (p1.x2 - p1.x1));
//    }

    public static void main(String[] args) {
        Point p1 = new Point(9,6);
        Point p2 = new Point(12,3);

//        System.out.println(distance(p1, p2));
        System.out.println(p1.distance(p2));
    }


}
