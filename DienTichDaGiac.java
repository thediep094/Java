package javaoop;

import java.util.ArrayList;
import java.util.Scanner;

public class DienTichDaGiac {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            DaGiac dg = new DaGiac();
            int n = in.nextInt();
            while (n-- > 0) {
                Point p = new Point(in.nextDouble(), in.nextDouble());
                dg.them(p);
                p = null;
            }
            System.out.printf("%.3f\n", dg.tinhDienTich());
        }
        in.close();
    }

    protected static class Point {
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

    protected static class DaGiac {
        private ArrayList<Point> ds;
        private double sigma;

        DaGiac() {
            this.ds = new ArrayList<>();
            this.sigma = 0;
        }

        protected void them(Point p) {
            this.ds.add(p);
        }

        protected double tinhDienTich() {
            for (int i = 0; i < this.ds.size(); i++) {
                if (i != this.ds.size() - 1) {
                    sigma += this.ds.get(i).getX() * this.ds.get(i + 1).getY()
                            - this.ds.get(i).getY() * this.ds.get(i + 1).getX();
                } else {
                    sigma += this.ds.get(i).getX() * this.ds.get(0).getY()
                            - this.ds.get(i).getY() * this.ds.get(0).getX();
                }
            }
            return Math.abs(sigma) / 2.0;
        }
    }
}
