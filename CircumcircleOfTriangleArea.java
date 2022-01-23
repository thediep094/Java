package javaoop;

import java.util.Scanner;

public class CircumcircleOfTriangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            Point3 a = new Point3();
            a.setX(input.nextDouble());
            a.setY(input.nextDouble());
            Point3 b = new Point3();
            b.setX(input.nextDouble());
            b.setY(input.nextDouble());
            Point3 c = new Point3();
            c.setX(input.nextDouble());
            c.setY(input.nextDouble());

            Double ab = a.distance(b);
            Double bc = b.distance(c);
            Double ac = a.distance(c);

            if (ab + ac <= bc || ab + bc <= ac || ac + bc <= ab) {
                System.out.println("INVALID");
            } else {
                Double area = (1.0 / 4) * Math.sqrt((ab + bc + ac) * (bc + ac - ab) * (ab + ac - bc) * (ab + bc - ac));
                Double circleArea = Math.PI * Math.pow((1.0 / (4 * area)) * (ab * bc * ac), 2.0);
                System.out.printf("%.3f\n", circleArea);
                // Math.round(area * 100.0) / 100.0 -> lam tron
            }
        }
        input.close();
    }
}

class Point3 {
    private Double x;
    private Double y;

    Point3() {

    }

    Point3(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    Point3(Point3 p) {
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

    protected Double distance(Point3 p) {
        Double tempA = Math.pow((Math.abs(this.x - p.getX())), 2);
        Double tempB = Math.pow((Math.abs(this.y - p.getY())), 2);
        return Math.sqrt(tempA + tempB);
    }

    public Double distance(Point3 p, Point3 q) {
        Double tempA = Math.pow((Math.abs(q.getX() - p.getX())), 2);
        Double tempB = Math.pow((Math.abs(q.getY() - p.getY())), 2);
        return Math.sqrt(tempA + tempB);
    }

}