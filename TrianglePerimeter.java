package javaoop;

import java.util.Scanner;

public class TrianglePerimeter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            Point1 a = new Point1();
            a.setX(input.nextDouble());
            a.setY(input.nextDouble());
            Point1 b = new Point1();
            b.setX(input.nextDouble());
            b.setY(input.nextDouble());
            Point1 c = new Point1();
            c.setX(input.nextDouble());
            c.setY(input.nextDouble());

            Double ab = a.distance(b);
            Double bc = b.distance(c);
            Double ac = a.distance(c);

            if (ab + ac <= bc || ab + bc <= ac || ac + bc <= ab) {
                System.out.println("INVALID");
            } else {
                System.out.printf("%.3f\n", ab + ac + bc);
            }
        }
        input.close();
    }
}

class Point1 {
    private Double x;
    private Double y;

    Point1() {

    }

    Point1(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    Point1(Point1 p) {
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

    protected Double distance(Point1 p) {
        Double tempA = Math.pow((Math.abs(this.x - p.getX())), 2);
        Double tempB = Math.pow((Math.abs(this.y - p.getY())), 2);
        return Math.sqrt(tempA + tempB);
    }

    public Double distance(Point1 p, Point1 q) {
        Double tempA = Math.pow((Math.abs(q.getX() - p.getX())), 2);
        Double tempB = Math.pow((Math.abs(q.getY() - p.getY())), 2);
        return Math.sqrt(tempA + tempB);
    }

}