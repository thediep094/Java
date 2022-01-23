package javaoop;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyBaiTapNhom {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        short n = in.nextShort();
        short m = in.nextShort();
        in.nextLine();
        DanhSachSinhVien ds = new DanhSachSinhVien();
        while (n-- > 0) {
            SinhVien sv = new SinhVien(in.nextLine(), in.nextLine(), in.nextLine(), in.nextShort());
            in.nextLine();
            ds.them(sv);
            sv = null;
        }
        BaiTap dsBaiTap = new BaiTap();
        while (m-- > 0) {
            dsBaiTap.them(in.nextLine());
        }
        int q = in.nextInt();
        while (q-- > 0) {
            short sttNhom = in.nextShort();
            DanhSachSinhVien ketqua = ds.timKiem(sttNhom);
            System.out.println(String.format("DANH SACH NHOM %d:", sttNhom));
            ketqua.hienThi();
            System.out.println(String.format("Bai tap dang ky: %s", dsBaiTap.layDeBai(sttNhom)));
        }
        in.close();
    }

    protected static class SinhVien {
        private String msv;
        private String ten;
        private String sdt;
        private short sttNhom;

        SinhVien() {

        }

        public SinhVien(String msv, String ten, String sdt, short sttNhom) {
            this.msv = msv;
            this.ten = ten;
            this.sdt = sdt;
            this.sttNhom = sttNhom;
        }

        public String getMsv() {
            return msv;
        }

        public void setMsv(String msv) {
            this.msv = msv;
        }

        public String getTen() {
            return ten;
        }

        public void setTen(String ten) {
            this.ten = ten;
        }

        public String getSdt() {
            return sdt;
        }

        public void setSdt(String sdt) {
            this.sdt = sdt;
        }

        public short getSttNhom() {
            return sttNhom;
        }

        public void setSttNhom(short sttNhom) {
            this.sttNhom = sttNhom;
        }

        @Override
        public String toString() {
            return String.format("%s %s %s", this.msv, this.ten, this.sdt);
        }
    }

    protected static class DanhSachSinhVien {
        private ArrayList<SinhVien> ds;

        DanhSachSinhVien() {
            this.ds = new ArrayList<>();
        }

        protected void them(SinhVien sv) {
            this.ds.add(sv);
        }

        protected DanhSachSinhVien timKiem(short sttNhom) {
            DanhSachSinhVien ketqua = new DanhSachSinhVien();
            for (SinhVien sv : this.ds) {
                if (sv.getSttNhom() == sttNhom) {
                    ketqua.them(sv);
                }
            }
            return ketqua;
        }

        protected void hienThi() {
            for (SinhVien sv : this.ds) {
                System.out.println(sv);
            }
        }
    }

    protected static class BaiTap {
        private ArrayList<String> dsBaiTap;

        BaiTap() {
            this.dsBaiTap = new ArrayList<>();
        }

        protected void them(String bt) {
            this.dsBaiTap.add(bt);
        }

        protected String layDeBai(short sttNhom) {
            return this.dsBaiTap.get(sttNhom - 1);
        }
    }
}
