package javaoop;

import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            Point2 a = new Point2();
            a.setX(input.nextDouble());
            a.setY(input.nextDouble());
            Point2 b = new Point2();
            b.setX(input.nextDouble());
            b.setY(input.nextDouble());
            Point2 c = new Point2();
            c.setX(input.nextDouble());
            c.setY(input.nextDouble());

            Double ab = a.distance(b);
            Double bc = b.distance(c);
            Double ac = a.distance(c);

            if (ab + ac <= bc || ab + bc <= ac || ac + bc <= ab) {
                System.out.println("INVALID");
            } else {
                Double area = (1.0 / 4) * Math.sqrt((ab + bc + ac) * (-ab + bc + ac) * (-bc + ab + ac) * (-ac + ab + bc));
                System.out.printf("%.2f\n", area);
                // Math.round(area * 100.0) / 100.0 -> lam tron
            }
        }
        input.close();
    }
}

class Point2 {
    private Double x;
    private Double y;

    Point2() {

    }

    Point2(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    Point2(Point2 p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    public Double getX() {
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

    protected Double distance(Point2 p) {
        Double tempA = Math.pow((Math.abs(this.x - p.getX())), 2);
        Double tempB = Math.pow((Math.abs(this.y - p.getY())), 2);
        return Math.sqrt(tempA + tempB);
    }

    public Double distance(Point2 p, Point2 q) {
        Double tempA = Math.pow((Math.abs(q.getX() - p.getX())), 2);
        Double tempB = Math.pow((Math.abs(q.getY() - p.getY())), 2);
        return Math.sqrt(tempA + tempB);
    }

}