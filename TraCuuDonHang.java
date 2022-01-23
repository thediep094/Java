package javaoop;

import java.util.ArrayList;
import java.util.Scanner;

public class TraCuuDonHang {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        DanhSachDonHang ds = new DanhSachDonHang();
        while (t-- > 0) {
            DonHang dh = new DonHang(in.nextLine(), in.nextLine(), in.nextInt(), in.nextShort());
            in.nextLine();
            ds.them(dh);
            dh = null;
        }
        ds.hienThi();
        in.close();

    }

    protected static class DonHang {
        private String tenHang;
        private String maDonHang;
        private int donGia;
        private short soLuong;

        DonHang() {

        }

        public DonHang(String tenHang, String maDonHang, int donGia, short soLuong) {
            this.tenHang = tenHang;
            this.maDonHang = maDonHang;
            this.donGia = donGia;
            this.soLuong = soLuong;
        }

        public String getTenHang() {
            return tenHang;
        }

        public void setTenHang(String tenHang) {
            this.tenHang = tenHang;
        }

        public String getMaDonHang() {
            return maDonHang;
        }

        public void setMaDonHang(String maDonHang) {
            this.maDonHang = maDonHang;
        }

        public int getDonGia() {
            return donGia;
        }

        public void setDonGia(int donGia) {
            this.donGia = donGia;
        }

        public short getSoLuong() {
            return soLuong;
        }

        public void setSoLuong(short soLuong) {
            this.soLuong = soLuong;
        }

        public String getSTTDonHang() {
            return this.maDonHang.substring(1, 4);
        }

        public int getGiamGia() {
            if (this.maDonHang.charAt(4) == '2') {
                return this.donGia * this.soLuong * 3 / 10;
            } else {
                return this.donGia * this.soLuong * 5 / 10;
            }
        }

        public int getThanhTien() {
            return this.donGia * this.soLuong - this.getGiamGia();
        }

        @Override
        public String toString() {
            return String.format("%s %s %s %d %d", this.tenHang, this.maDonHang, this.getSTTDonHang(),
                    this.getGiamGia(), this.getThanhTien());
        }
    }

    protected static class DanhSachDonHang {
        private ArrayList<DonHang> ds;

        DanhSachDonHang() {
            this.ds = new ArrayList<>();
        }

        protected void them(DonHang dh) {
            this.ds.add(dh);
        }

        

        protected void hienThi() {
            for (DonHang dh : this.ds) {
                System.out.println(dh);
            }
        }
    }
}
