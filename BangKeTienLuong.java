package javaoop;

import java.util.ArrayList;
import java.util.Scanner;

public class BangKeTienLuong {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        DanhSachNhanVien ds = new DanhSachNhanVien();
        for (int i = 0; i < t; i++) {
            NhanVien nv = new NhanVien(i + 1, in.nextLine(), in.nextInt(), in.nextShort(), in.next());
            in.nextLine();
            ds.them(nv);
        }
        ds.hienThi();
        in.close();
    }

    protected static class NhanVien {
        private String mnv;
        private String ten;
        private String chucVu;
        private int luongCoBan;
        private short soNgayCong;

        NhanVien() {

        }

        NhanVien(int stt, String ten, int luongCoBan, short soNgayCong, String chucVu) {
            setMnv(stt);
            this.ten = ten;
            this.chucVu = chucVu;
            this.luongCoBan = luongCoBan;
            this.soNgayCong = soNgayCong;
        }

        public String getMnv() {
            return mnv;
        }

        public void setMnv(int stt) {
            this.mnv = "NV" + (stt < 10 ? "0" + stt : String.valueOf(stt));
        }

        public String getTen() {
            return ten;
        }

        public void setTen(String ten) {
            this.ten = ten;
        }

        public String getChucVu() {
            return chucVu;
        }

        public void setChucVu(String chucVu) {
            this.chucVu = chucVu;
        }

        public int getLuongCoBan() {
            return luongCoBan;
        }

        public void setLuongCoBan(int luongCoBan) {
            this.luongCoBan = luongCoBan;
        }

        public short getSoNgayCong() {
            return soNgayCong;
        }

        public void setSoNgayCong(short soNgayCong) {
            this.soNgayCong = soNgayCong;
        }

        public int getPhuCap() {
            switch (this.chucVu) {
                case "GD":
                    return 250000;
                case "PGD":
                    return 200000;
                case "TP":
                    return 180000;
                default:
                    return 150000;
            }
        }

        public int getLuongChinh() {
            return this.luongCoBan * this.soNgayCong;
        }

        public int getThuong() {
            if (this.soNgayCong >= 25) {
                return this.getLuongChinh() * 20 / 100;
            } else if (this.soNgayCong >= 22) {
                return this.getLuongChinh() * 10 / 100;
            }
            return 0;
        }

        @Override
        public String toString() {
            return String.format("%s %s %d %d %d %d", this.mnv, this.ten, this.getLuongChinh(), this.getThuong(),
                    this.getPhuCap(), this.getLuongChinh() + this.getPhuCap() + this.getThuong());
        }
    }

    protected static class DanhSachNhanVien {
        private final ArrayList<NhanVien> ds;
        private int tong;

        DanhSachNhanVien() {
            this.ds = new ArrayList<>();
            this.tong = 0;
        }

        protected void them(NhanVien nv) {
            this.ds.add(nv);
            tong += nv.getLuongChinh() + nv.getThuong() + nv.getPhuCap();
        }

        protected void hienThi() {
            for (NhanVien nv : this.ds) {
                System.out.println(nv);
            }
            System.out.println("Tong chi phi tien luong: " + this.tong);
        }
    }
}
