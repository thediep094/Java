package javaoop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class HoaDonTienNuoc {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        DanhSachHoaDon ds = new DanhSachHoaDon();
        while (t-- > 0) {
            HoaDon hd = new HoaDon(in.nextLine(), in.nextInt(), in.nextInt());
            in.nextLine();
            ds.them(hd);
            hd = null;
        }
        ds.sapXep();
        ds.hienThi();
        in.close();
    }

    protected static class HoaDon {
        private String maKh;
        private String tenKh;
        private int chiSoCu;
        private int chiSoMoi;

        HoaDon() {

        }

        public HoaDon(String tenKh, int chiSoCu, int chiSoMoi) {
            this.tenKh = tenKh;
            this.chiSoCu = chiSoCu;
            this.chiSoMoi = chiSoMoi;
        }

        public String getMaKh() {
            return maKh;
        }

        public void setMaKh(int stt) {
            this.maKh = "KH" + (stt < 10 ? "0" + String.valueOf(stt) : String.valueOf(stt));
        }

        public String getTenKh() {
            return tenKh;
        }

        public void setTenKh(String tenKh) {
            this.tenKh = tenKh;
        }

        public int getChiSoCu() {
            return chiSoCu;
        }

        public void setChiSoCu(int chiSoCu) {
            this.chiSoCu = chiSoCu;
        }

        public int getChiSoMoi() {
            return chiSoMoi;
        }

        public void setChiSoMoi(int chiSoMoi) {
            this.chiSoMoi = chiSoMoi;
        }

        public long getThanhTien() {
            int soLuongNuoc = this.chiSoMoi - this.chiSoCu;
            if (soLuongNuoc <= 50) {
                return (long) Math.ceil(soLuongNuoc * 100 * 1.02);
            } else if (soLuongNuoc <= 100) {
                return (long) Math.ceil(((50 * 100) + (soLuongNuoc - 50) * 150) * 1.03);
            } else {
                return (long) Math.ceil(((50 * 100) + 50 * 150 + (soLuongNuoc - 100) * 200) * 1.05);
            }
        }

        @Override
        public String toString() {
            return String.format("%s %s %d", this.maKh, this.tenKh, this.getThanhTien());
        }
    }

    protected static class DanhSachHoaDon {
        private ArrayList<HoaDon> ds;

        DanhSachHoaDon() {
            this.ds = new ArrayList<>();
        }

        protected void them(HoaDon hd) {
            hd.setMaKh(this.ds.size() + 1);
            this.ds.add(hd);
        }

        protected void sapXep() {
            Collections.sort(this.ds, new Comparator<HoaDon>() {
                public int compare(HoaDon a, HoaDon b) {
                    return b.getThanhTien() >= a.getThanhTien() ? 1 : -1;
                }
            });
        }

        protected void hienThi() {
            for (HoaDon hd : this.ds) {
                System.out.println(hd);
            }
        }
    }
}
