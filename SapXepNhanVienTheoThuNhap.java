package javaoop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SapXepNhanVienTheoThuNhap {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        DanhSachNhanVien ds = new DanhSachNhanVien();
        for (int i = 0; i < t; i++) {
            NhanVien nv = new NhanVien(i + 1, in.nextLine(), in.nextLine(), in.nextInt(), in.nextShort());
            in.nextLine();
            ds.them(nv);
            nv = null;
        }
        ds.sapXep();
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

        public NhanVien(int stt, String ten, String chucVu, int luongCoBan, short soNgayCong) {
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
            this.mnv = "NV" + (stt < 10 ? "0" + String.valueOf(stt) : String.valueOf(stt));
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
                    return 500;
                case "PGD":
                    return 400;
                case "TP":
                    return 300;
                case "KT":
                    return 250;
                default:
                    return 100;
            }
        }

        public int getLuongChinh() {
            return this.luongCoBan * this.soNgayCong;
        }

        public int getTamUng() {
            double temp = (this.getPhuCap() + this.getLuongChinh()) * 2.0 / 3;
            if (temp < 25000) {
                return (int) Math.round(temp / 1000.0) * 1000;
            } else {
                return 25000;
            }
        }

        @Override
        public String toString() {
            return String.format("%s %s %d %d %d %d", this.mnv, this.ten, this.getPhuCap(), this.getLuongChinh(),
                    this.getTamUng(), this.getPhuCap() + this.getLuongChinh() - this.getTamUng());
        }
    }

    protected static class DanhSachNhanVien {
        private ArrayList<NhanVien> ds;

        DanhSachNhanVien() {
            this.ds = new ArrayList<>();
        }

        protected void them(NhanVien nv) {
            this.ds.add(nv);
        }

        protected void sapXep() {
            Collections.sort(this.ds, new Comparator<NhanVien>(){
                public int compare(NhanVien a, NhanVien b) {
                    if (a.getLuongChinh() + a.getPhuCap() == b.getLuongChinh() + b.getPhuCap()) {
                        return a.getMnv().compareTo(b.getMnv());
                    }
                    return (b.getLuongChinh() + b.getPhuCap()) - (a.getLuongChinh() + a.getPhuCap());
                }
            });
        }

        protected void hienThi() {
            for (NhanVien nv : this.ds) {
                System.out.println(nv);
            }
        }
    }
}

