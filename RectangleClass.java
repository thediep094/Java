package javaoop;

import java.util.Scanner;

public class RectangleClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Double a = input.nextDouble();
        Double b = input.nextDouble();
        String color = input.next().trim();
        if (a > 0 && b > 0) {
            Rectangle1 rec = new Rectangle1(a, b, color);
            System.out.printf("%d %d %s", rec.findPerimeter().longValue(), rec.findArea().longValue(), rec.getColor());
        } else {
            System.out.print("INVALID");
        }
        input.close();
    }
}

class Rectangle1 {
    private Double width;
    private Double height;
    private String color;

    Rectangle1() {
        this.width = (double) 1;
        this.height = (double) 1;
    }

    Rectangle1(Double width, Double height, String color) {
        this.width = width;
        this.height = height;
        setColor(color);
    }

    protected Double getWidth() {
        return this.width;
    }

    protected void setWidth(Double width) {
        this.width = width;
    }

    protected Double getHeight() {
        return this.height;
    }

    protected void setHeight(Double height) {
        this.height = height;
    }

    protected String getColor() {
        return this.color;
    }

    protected void setColor(String color) {
        this.color = color.toUpperCase().charAt(0) + color.toLowerCase().substring(1);
    }

    protected Double findArea() {
        return this.width * this.height;
    }

    protected Double findPerimeter() {
        return 2 * (this.width + this.height);
    }
}
