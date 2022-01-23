package javaoop;

import java.util.Scanner;

public class SoPhuc {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int t = in.nextInt();
        while (t-- > 0) {
            Comp cmpA = new Comp(in.nextInt(), in.nextInt());
            Comp cmpB = new Comp(in.nextInt(), in.nextInt());
            Comp cmpC = cmpA.cong(cmpB).nhan(cmpA);
            Comp cmpD = cmpA.cong(cmpB).nhan(cmpA.cong(cmpB));
            System.out.println(cmpC + ", " + cmpD);
        }
    }

    protected static class Comp {
        private int a;
        private int b;

        Comp() {

        }

        Comp(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        protected Comp cong(Comp cmp) {
            return new Comp(this.a + cmp.getA(), this.b + cmp.getB());
        }

        protected Comp nhan(Comp cmp) {
            return new Comp((this.a * cmp.getA()) - (this.b * cmp.getB()),
                    (this.a * cmp.getB()) + (this.b * cmp.getA()));
        }

        @Override
        public String toString() {
            return String.format("%d %s %di", this.a, this.b < 0 ? "-" : "+", this.b < 0 ? this.b * -1 : this.b);
        }
    }
}
