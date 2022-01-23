package javaoop;

import java.util.Scanner;

public class FractionAddition {
    static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        PhanSo1 a = new PhanSo1(1, 1);
        PhanSo1 b = new PhanSo1(1, 1);
        PhanSo1 c = new PhanSo1(1, 1);
        a.nhap(input);
        b.nhap(input);
        c.sum(a, b);
        System.out.print(c);
    }
}

class PhanSo1 {
    protected long tuSo;
    protected long mauSo;

    PhanSo1(long a, long b) {
        this.tuSo = a;
        this.mauSo = b;
    }

    @Override
    public String toString() {
        return this.tuSo + "/" + this.mauSo;
    }

    protected void nhap(Scanner input) {
        this.tuSo = input.nextLong();
        this.mauSo = input.nextLong();
    }

    protected void rutGon() {
        long GCD = this.GCD(this.tuSo, this.mauSo);
        this.tuSo /= GCD;
        this.mauSo /= GCD;
    }

    protected long GCD(long a, long b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }

    protected void sum(PhanSo1 a, PhanSo1 b) {
        this.tuSo = a.tuSo * b.mauSo + b.tuSo * a.mauSo;
        this.mauSo = a.mauSo * b.mauSo;
        this.rutGon();
    }
}
