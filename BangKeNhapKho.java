package javaoop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BangKeNhapKho {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        DanhSachMatHang ds = new DanhSachMatHang();
        while (t-- > 0) {
            MatHang mh = new MatHang(in.nextLine(), in.nextShort(), in.nextInt());
            in.nextLine();
            ds.them(mh);
            mh = null;
        }
        ds.hienThi();
        in.close();
    }

    public static String getMa(String tenHang) {
        String result = "";
        String[] temp = tenHang.toUpperCase().split("((?<=[A-Z]{1})[A-Z]+\\s?)");
        for (int i = 0; i < temp.length && i < 2; i++) {
            result += temp[i];
        }
        return result;
    }

    protected static class MatHang {
        private String maHang;
        private String tenHang;
        private short soLuong;
        private int donGia;
        private int chietKhau;
        private long thanhTien;

        MatHang() {

        }

        public MatHang(String tenHang, short soLuong, int donGia) {
            this.tenHang = tenHang;
            this.soLuong = soLuong;
            this.donGia = donGia;
            setChietKhau();
            setThanhTien();
        }

        public String getMaHang() {
            return maHang;
        }

        public void setMaHang(int stt) {
            this.maHang = getMa(this.tenHang) + (stt < 10 ? "0" + String.valueOf(stt) : String.valueOf(stt));
        }

        public String getTenHang() {
            return tenHang;
        }

        public void setTenHang(String tenHang) {
            this.tenHang = tenHang;
        }

        public short getSoLuong() {
            return soLuong;
        }

        public void setSoLuong(short soLuong) {
            this.soLuong = soLuong;
        }

        public int getDonGia() {
            return donGia;
        }

        public void setDonGia(int donGia) {
            this.donGia = donGia;
        }

        public int getChietKhau() {
            return chietKhau;
        }

        public void setChietKhau() {
            int phanTramChietKhau = 0;
            if (this.soLuong > 10) {
                phanTramChietKhau = 5;
            } else if (this.soLuong >= 8) {
                phanTramChietKhau = 2;
            } else if (this.soLuong >= 5) {
                phanTramChietKhau = 1;
            }
            this.chietKhau = this.donGia * this.soLuong * phanTramChietKhau / 100;
        }

        public long getThanhTien() {
            return thanhTien;
        }

        public void setThanhTien() {
            this.thanhTien = this.donGia * this.soLuong - this.chietKhau;
        }

        @Override
        public String toString() {
            return String.format("%s %s %d %d", this.maHang, this.tenHang, this.chietKhau, this.thanhTien);
        }
    }

    protected static class DanhSachMatHang {
        ArrayList<MatHang> ds;
        HashMap<String, Integer> hm;

        DanhSachMatHang() {
            this.ds = new ArrayList<>();
            this.hm = new HashMap<>();
        }

        protected void them(MatHang mh) {
            String maHang = getMa(mh.getTenHang());
            if (hm.get(maHang) == null) {
                hm.put(maHang, 1);
            } else {
                hm.replace(maHang, hm.get(maHang) + 1);
            }
            mh.setMaHang(hm.get(maHang));
            this.ds.add(mh);
        }

        protected void hienThi() {
            for (MatHang mh : this.ds) {
                System.out.println(mh);
            }
        }
    }
}
