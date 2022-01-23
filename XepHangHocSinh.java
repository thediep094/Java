package javaoop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class XepHangHocSinh {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        DanhSachHocSinh ds = new DanhSachHocSinh();
        while (t-- > 0) {
            HocSinh a = new HocSinh(in.nextLine(), in.nextFloat());
            in.nextLine();
            ds.them(a);
            a = null;
        }
        ds.sapXep();
        ds.hienThi();
        in.close();
    }

    protected static class HocSinh {
        private String maHs;
        private String ten;
        private float diem;

        HocSinh() {

        }

        public HocSinh(String ten, float diem) {
            this.ten = ten;
            this.diem = diem;
        }

        public String getMaHs() {
            return maHs;
        }

        public void setMaHs(int stt) {
            this.maHs = "HS" + (stt < 10 ? "0" + String.valueOf(stt) : String.valueOf(stt));
        }

        public String getTen() {
            return ten;
        }

        public void setTen(String ten) {
            this.ten = ten;
        }

        public float getDiem() {
            return diem;
        }

        public void setDiem(float diem) {
            this.diem = diem;
        }

        public String getXepLoai() {
            if (this.diem < 5) {
                return "Yeu";
            } else if (this.diem < 7) {
                return "Trung Binh";
            } else if (this.diem < 9) {
                return "Kha";
            } else {
                return "Gioi";
            }
        }

        @Override
        public String toString() {
            return String.format("%s %s %.1f %s", this.maHs, this.ten, this.diem, this.getXepLoai());
        }
    }

    protected static class DanhSachHocSinh {
        private ArrayList<HocSinh> ds;
        private HashMap<String, Short> hm;

        DanhSachHocSinh() {
            this.ds = new ArrayList<>();
            this.hm = new HashMap<>();
        }

        protected void them(HocSinh a) {
            a.setMaHs(this.ds.size() + 1);
            this.ds.add(a);
        }

        protected void sapXep() {
            Collections.sort(this.ds, new Comparator<HocSinh>() {
                public int compare(HocSinh a, HocSinh b) {
                    return b.getDiem() >= a.getDiem() ? 1 : -1;
                }
            });
            short counter = 1;
            for (int i = 0; i < this.ds.size(); i++) {
                if (i > 0 && this.ds.get(i).getDiem() != this.ds.get(i - 1).getDiem()) {
                    counter = (short) (i + 1);
                }
                hm.put(this.ds.get(i).getMaHs(), counter);
            }
            Collections.sort(this.ds, new Comparator<HocSinh>() {
                public int compare(HocSinh a, HocSinh b) {
                    return a.getMaHs().compareTo(b.getMaHs());
                }
            });
        }

        protected void hienThi() {
            for (HocSinh a : this.ds) {
                System.out.println(a + " " + this.hm.get(a.getMaHs()));
            }
        }
    }
}
