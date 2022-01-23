package javaoop;

import java.util.ArrayList;
import java.util.Scanner;

public class BangTheoDoiNhapXuatHang {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        DanhSachHang ds = new DanhSachHang();
        while (t-- > 0) {
            Hang a = new Hang(in.nextLine(), in.nextInt());
            in.nextLine();
            ds.them(a);
            a = null;
        }
        ds.hienThi();
        in.close();
    }

    protected static class Hang {
        private String maHang;
        private int soLuongNhap;

        Hang() {

        }

        public Hang(String maHang, int soLuongNhap) {
            this.maHang = maHang;
            this.soLuongNhap = soLuongNhap;
        }

        public String getMaHang() {
            return maHang;
        }

        public void setMaHang(String maHang) {
            this.maHang = maHang;
        }

        public int getSoLuongNhap() {
            return soLuongNhap;
        }

        public void setSoLuongNhap(int soLuongNhap) {
            this.soLuongNhap = soLuongNhap;
        }

        public int getSoLuongXuat() {
            if (this.maHang.startsWith("A")) {
                return (int) Math.round(this.soLuongNhap * 6.0 / 10);
            } else {
                return (int) Math.round(this.soLuongNhap * 7.0 / 10);
            }
        }

        public long getDonGia() {
            if (this.maHang.endsWith("Y")) {
                return 110000;
            } else {
                return 135000;
            }
        }

        public long getTien() {
            return this.getSoLuongXuat() * this.getDonGia();
        }

        public long getThue() {
            double thue = 0;
            if (this.maHang.startsWith("A") && this.maHang.endsWith("Y")) {
                thue = 8.0 / 100;
            }
            if (this.maHang.startsWith("A") && this.maHang.endsWith("N")) {
                thue = 11.0 / 100;
            }
            if (this.maHang.startsWith("B") && this.maHang.endsWith("Y")) {
                thue = 17.0 / 100;
            }
            if (this.maHang.startsWith("B") && this.maHang.endsWith("N")) {
                thue = 22.0 / 100;
            }
            return (long) (this.getTien() * thue);
        }

        @Override
        public String toString() {
            return String.format("%s %d %d %d %d %d", this.maHang, this.soLuongNhap, this.getSoLuongXuat(),
                    this.getDonGia(), this.getTien(), this.getThue());
        }
    }

    protected static class DanhSachHang {
        private ArrayList<Hang> ds;

        DanhSachHang() {
            this.ds = new ArrayList<>();
        }

        protected void them(Hang a) {
            this.ds.add(a);
        }

        protected void hienThi() {
            for (Hang a : this.ds) {
                System.out.println(a);
            }
        }
    }
}
