package javaoop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SapXepBangTinhCong {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DanhSachNhanVien ds = new DanhSachNhanVien();
        int t = in.nextInt();
        in.nextLine();
        while (t-- > 0) {
            NhanVien nv = new NhanVien();
            nv.setHoTen(in.nextLine());
            nv.setLuongCoBan(in.nextInt());
            nv.setSoNgayCong(in.nextInt());
            in.nextLine();
            nv.setChucVu(in.nextLine());
            ds.them(nv);
            nv = null;
        }
        ds.sapXep();
        ds.hienThi();
        in.close();
    }

    protected static class NhanVien {
        private String hoTen;
        private int luongCoBan;
        private int soNgayCong;
        private String chucVu;
        private String maNv;

        NhanVien() {

        }

        NhanVien(String hoTen, int luongCoBan, int soNgayCong, String chucVu) {
            this.hoTen = hoTen.trim();
            this.luongCoBan = luongCoBan;
            this.soNgayCong = soNgayCong;
            this.chucVu = chucVu.trim();
        }

        public String getMaNv() {
            return maNv;
        }

        public void setMaNv(int stt) {
            this.maNv = "NV" + (stt < 10 ? "0" + String.valueOf(stt) : String.valueOf(stt));
        }

        public String getHoTen() {
            return hoTen;
        }

        public void setHoTen(String hoTen) {
            this.hoTen = hoTen;
        }

        public int getLuongCoBan() {
            return luongCoBan;
        }

        public void setLuongCoBan(int luongCoBan) {
            this.luongCoBan = luongCoBan;
        }

        public int getSoNgayCong() {
            return soNgayCong;
        }

        public void setSoNgayCong(int soNgayCong) {
            this.soNgayCong = soNgayCong;
        }

        public String getChucVu() {
            return chucVu;
        }

        public void setChucVu(String chucVu) {
            this.chucVu = chucVu;
        }

        public int getTienLuong() {
            return this.soNgayCong * this.luongCoBan;
        }

        public int getTienThuong() {
            if (this.soNgayCong >= 25) {
                return this.getTienLuong() * 2 / 10;
            } else if (this.soNgayCong >= 22) {
                return this.getTienLuong() * 1 / 10;
            } else {
                return 0;
            }
        }

        public int getPhuCap() {
            if (this.chucVu.compareTo("GD") == 0) {
                return 250000;
            }
            if (this.chucVu.compareTo("PGD") == 0) {
                return 200000;
            }
            if (this.chucVu.compareTo("TP") == 0) {
                return 180000;
            }
            return 150000;
        }

        public int getTongThuNhap() {
            return this.getTienLuong() + this.getTienThuong() + this.getPhuCap();
        }

        @Override
        public String toString() {
            return String.format("%s %s %d %d %d %d", this.maNv, this.hoTen, this.getTienLuong(), this.getTienThuong(),
                    this.getPhuCap(), this.getTongThuNhap());
        }
    }

    protected static class DanhSachNhanVien {
        private ArrayList<NhanVien> ds;

        DanhSachNhanVien() {
            this.ds = new ArrayList<>();
        }

        protected void them(NhanVien nv) {
            nv.setMaNv(this.ds.size() + 1);
            this.ds.add(nv);
        }

        protected void sapXep() {
            Collections.sort(this.ds, new Comparator<NhanVien>() {
                public int compare(NhanVien a, NhanVien b) {
                    return b.getTongThuNhap() >= a.getTongThuNhap() ? 1 : -1;
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
