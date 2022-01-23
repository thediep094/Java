package javaoop;

import java.util.Scanner;

public class Fraction {
    public static void main(String[] args) {
        PhanSo p = new PhanSo(1, 1);
        p.nhap();
        p.rutGon();
        System.out.println(p);
    }
}

class PhanSo {
    private long tuSo;
    private long mauSo;

    PhanSo(long a, long b) {
        this.tuSo = a;
        this.mauSo = b;
    }

    @Override
    public String toString() {
        return this.tuSo + "/" + this.mauSo;
    }

    protected void nhap() {
        Scanner input = new Scanner(System.in);
        this.tuSo = input.nextLong();
        this.mauSo = input.nextLong();
        input.close();
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
}