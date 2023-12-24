package models;

import java.util.ArrayList;
import java.util.List;

public class Shape {
    private List<Point> points;

    public Shape() {
        this.points = new ArrayList<>();
    }

    // addPoint(Point) - adds to the container
    public void addPoint(Point point) {
        points.add(point);
    }

    public double calculatePerimeter() {
        double perimeter = 0;
        int size = points.size();

        for (int i = 0; i < size; i++) {
            Point currentPoint = points.get(i);
            Point nextPoint = points.get((i + 1) % size);
            perimeter += currentPoint.distance(nextPoint);
        }

        return perimeter;
    }

    public double findLongestSide() {
        double longestSide = 0;

        for (int i = 0; i < points.size(); i++) {
            Point currentPoint = points.get(i);
            Point nextPoint = points.get((i + 1) % points.size());
            double currentDistance = currentPoint.distance(nextPoint);

            if (currentDistance > longestSide) {
                longestSide = currentDistance;
            }
        }

        return longestSide;
    }

    public double getAverageSide() {
        return calculatePerimeter() / points.size();
    }
}


