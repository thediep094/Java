package javaoop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class DanhSachThucTap2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        DanhSachSinhVien ds = new DanhSachSinhVien();
        for (int i = 0; i < t; i++) {
            SinhVien sv = new SinhVien((short) (i + 1), in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine());
            ds.add(sv);
            sv = null;
        }
        int q = in.nextInt();
        in.nextLine();
        while (q-- > 0) {
            String doanhNghiep = in.nextLine();
            DanhSachSinhVien result = ds.timKiem(doanhNghiep);
            result.sapXep();
            result.hienThi();
        }
        in.close();
    }

    protected static class SinhVien {
        private short stt;
        private String msv;
        private String ten;
        private String lop;
        private String email;
        private String doanhNghiep;

        SinhVien() {
            this.stt = 1;
        }

        public SinhVien(short stt, String msv, String ten, String lop, String email, String doanhNghiep) {
            this.stt = stt;
            this.msv = msv;
            this.ten = ten;
            this.lop = lop;
            this.email = email;
            this.doanhNghiep = doanhNghiep;
        }

        public short getStt() {
            return stt;
        }

        public void setStt(short stt) {
            this.stt = stt;
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

        public String getLop() {
            return lop;
        }

        public void setLop(String lop) {
            this.lop = lop;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getDoanhNghiep() {
            return doanhNghiep;
        }

        public void setDoanhNghiep(String doanhNghiep) {
            this.doanhNghiep = doanhNghiep;
        }

        @Override
        public String toString() {
            return String.format("%d %s %s %s %s %s", this.stt, this.msv, this.ten, this.lop, this.email,
                    this.doanhNghiep);
        }
    }

    protected static class DanhSachSinhVien {
        private ArrayList<SinhVien> ds;

        DanhSachSinhVien() {
            this.ds = new ArrayList<>();
        }

        protected void add(SinhVien sv) {
            this.ds.add(sv);
        }

        protected void sapXep() {
            Collections.sort(this.ds, new Comparator<SinhVien>() {
                public int compare(SinhVien a, SinhVien b) {
                    return a.getMsv().compareTo(b.getMsv());
                }
            });
        }

        protected DanhSachSinhVien timKiem(String doanhNghiep) {
            DanhSachSinhVien result = new DanhSachSinhVien();
            for (SinhVien sv : this.ds) {
                if (sv.getDoanhNghiep().compareToIgnoreCase(doanhNghiep) == 0) {
                    result.add(sv);
                }
            }
            return result;
        }

        protected void hienThi() {
            for (SinhVien sv : this.ds) {
                System.out.println(sv);
            }
        }
    }
}
