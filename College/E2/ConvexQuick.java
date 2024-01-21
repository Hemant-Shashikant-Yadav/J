package CollegeDAA.E2;

import java.util.ArrayList;
import java.util.List;

class Point {
    double x, y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

public class ConvexQuick {

    public static List<Point> quickHull(List<Point> points) {
        List<Point> convexHull = new ArrayList<>();

        if (points.size() < 3) {
            return points;
        }

        int minIndex = 0, maxIndex = 0;
        for (int i = 1; i < points.size(); i++) {
            if (points.get(i).x < points.get(minIndex).x) {
                minIndex = i;
            }
            if (points.get(i).x > points.get(maxIndex).x) {
                maxIndex = i;
            }
        }

        Point p1 = points.get(minIndex);
        Point p2 = points.get(maxIndex);

        convexHull.add(p1);
        convexHull.add(p2);

        points.remove(p1);
        points.remove(p2);

        List<Point> leftSet = new ArrayList<>();
        List<Point> rightSet = new ArrayList<>();

        for (Point point : points) {
            if (pointPosition(p1, p2, point) == -1) {
                leftSet.add(point);
            } else if (pointPosition(p1, p2, point) == 1) {
                rightSet.add(point);
            }
        }

        hullSet(p1, p2, rightSet, convexHull);
        hullSet(p2, p1, leftSet, convexHull);

        return convexHull;
    }

    private static void hullSet(Point p1, Point p2, List<Point> set, List<Point> hull) {
        int insertPosition = hull.indexOf(p2);

        if (set.isEmpty()) {
            return;
        }

        if (set.size() == 1) {
            Point point = set.get(0);
            set.remove(point);
            hull.add(insertPosition, point);
            return;
        }

        double dist = Double.MIN_VALUE;
        int furthestPoint = -1;

        for (int i = 0; i < set.size(); i++) {
            Point point = set.get(i);
            double distance = distance(p1, p2, point);
            if (distance > dist) {
                dist = distance;
                furthestPoint = i;
            }
        }

        Point furthest = set.get(furthestPoint);
        set.remove(furthest);
        hull.add(insertPosition, furthest);

        List<Point> leftSet = new ArrayList<>();
        for (Point point : set) {
            if (pointPosition(p1, furthest, point) == 1) {
                leftSet.add(point);
            }
        }

        List<Point> rightSet = new ArrayList<>();
        for (Point point : set) {
            if (pointPosition(furthest, p2, point) == 1) {
                rightSet.add(point);
            }
        }

        hullSet(p1, furthest, leftSet, hull);
        hullSet(furthest, p2, rightSet, hull);
    }

    private static int pointPosition(Point p1, Point p2, Point p) {
        double position = (p2.y - p1.y) * (p.x - p1.x) - (p2.x - p1.x) * (p.y - p1.y);
        if (position > 0) {
            return 1;
        } else if (position < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    private static double distance(Point p1, Point p2, Point p) {
        double A = p.y - p1.y;
        double B = p.x - p1.x;
        double C = p2.x - p1.x;
        double D = p2.y - p1.y;

        double dot = A * C + B * D;
        double len_sq = C * C + D * D;
        double param = dot / len_sq;

        double xx, yy;

        if (param < 0 || (p1.x == p2.x && p1.y == p2.y)) {
            xx = p1.x;
            yy = p1.y;
        } else if (param > 1) {
            xx = p2.x;
            yy = p2.y;
        } else {
            xx = p1.x + param * C;
            yy = p1.y + param * D;
        }

        double dx = p.x - xx;
        double dy = p.y - yy;

        return Math.sqrt(dx * dx + dy * dy);
    }

    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        points.add(new Point(1, 3));
        points.add(new Point(2, 2));
        points.add(new Point(4, 4));
        points.add(new Point(0, 5));
        points.add(new Point(1, 1));
        points.add(new Point(3, 1));
        points.add(new Point(3, 3));

        List<Point> convexHull = quickHull(points);

        System.out.println("Convex Hull Points:");
        for (Point point : convexHull) {
            System.out.println("(" + point.x + ", " + point.y + ")");
        }
    }
}
