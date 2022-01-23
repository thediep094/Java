package javaoop;

import java.util.Scanner;

public class PointClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            Point a = new Point();
            Point b = new Point();
            a.setX(input.nextDouble());
            a.setY(input.nextDouble());
            b.setX(input.nextDouble());
            b.setY(input.nextDouble());
            System.out.println(String.format("%.4f", a.distance(b)));
        }
        input.close();
    }
}

class Point {
    private Double x;
    private Double y;

    Point() {

    }

    Point(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    Point(Point p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    protected Double getX() {
        return x;
    }

    protected void setX(Double x) {
        this.x = x;
    }

    protected Double getY() {
        return y;
    }

    protected void setY(Double y) {
        this.y = y;
    }

    protected Double distance(Point p) {
        Double tempA = Math.pow((Math.abs(this.x - p.getX())), 2);
        Double tempB = Math.pow((Math.abs(this.y - p.getY())), 2);
        return Math.sqrt(tempA + tempB);
    }

    public Double distance(Point p, Point q) {
        Double tempA = Math.pow((Math.abs(q.getX() - p.getX())), 2);
        Double tempB = Math.pow((Math.abs(q.getY() - p.getY())), 2);
        return Math.sqrt(tempA + tempB);
    }

}
