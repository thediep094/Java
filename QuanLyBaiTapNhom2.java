package javaoop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QuanLyBaiTapNhom2 {
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
        ds.sapXep();
        BaiTap dsBaiTap = new BaiTap();
        while (m-- > 0) {
            dsBaiTap.them(in.nextLine());
        }
        for (SinhVien sv : ds.getDs()) {
            System.out.println(sv + " " + dsBaiTap.layDeBai(sv.getSttNhom()));
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
            return String.format("%s %s %s %d", this.msv, this.ten, this.sdt, this.sttNhom);
        }
    }

    protected static class DanhSachSinhVien {
        private ArrayList<SinhVien> ds;

        DanhSachSinhVien() {
            this.ds = new ArrayList<>();
        }

        public ArrayList<SinhVien> getDs() {
            return ds;
        }

        public void setDs(ArrayList<SinhVien> ds) {
            this.ds = ds;
        }

        protected void them(SinhVien sv) {
            this.ds.add(sv);
        }

        protected void sapXep() {
            Collections.sort(this.ds, new Comparator<SinhVien>() {
                public int compare(SinhVien a, SinhVien b) {
                    return a.getMsv().compareTo(b.getMsv());
                }
            });
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
