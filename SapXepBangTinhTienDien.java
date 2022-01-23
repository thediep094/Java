package javaoop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SapXepBangTinhTienDien {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        DanhSachKhachHang ds = new DanhSachKhachHang();
        while (t-- > 0) {
            KhachHang kh = new KhachHang(in.nextLine(), in.nextInt(), in.nextInt());
            in.nextLine();
            ds.them(kh);
            kh = null;
        }
        ds.sapXep();
        ds.hienThi();
        in.close();
    }

    protected static class KhachHang {
        private String ma;
        private String loaiSuDung;
        private int chiSoCu;
        private int chiSoMoi;

        KhachHang() {

        }

        public KhachHang(String loaiSuDung, int chiSoCu, int chiSoMoi) {
            this.loaiSuDung = loaiSuDung;
            this.chiSoCu = chiSoCu;
            this.chiSoMoi = chiSoMoi;
        }

        public String getMa() {
            return ma;
        }

        public void setMa(int stt) {
            this.ma = "KH" + (stt < 10 ? "0" + String.valueOf(stt) : String.valueOf(stt));
        }

        public String getLoaiSuDung() {
            return loaiSuDung;
        }

        public void setLoaiSuDung(String loaiSuDung) {
            this.loaiSuDung = loaiSuDung;
        }

        public short getHeSo() {
            short heSo = 0;
            switch (this.loaiSuDung) {
                case "KD":
                    heSo = 3;
                    break;

                case "NN":
                    heSo = 5;
                    break;
                case "TT":
                    heSo = 4;
                    break;
                case "CN":
                    heSo = 2;
                    break;
                default:
                    break;
            }
            return heSo;
        }

        public int getThanhTien() {
            return (this.chiSoMoi - this.chiSoCu) * this.getHeSo() * 550;
        }

        public int getPhuTroi() {
            int phuTroi = 0;
            if (this.chiSoMoi - this.chiSoCu < 50) {
                phuTroi = 0;
            } else if (this.chiSoMoi - this.chiSoCu <= 100) {
                phuTroi = (int) Math.round(this.getThanhTien() * 35.0 / 100);
            } else if (this.chiSoMoi - this.chiSoCu > 100) {
                phuTroi = this.getThanhTien();
            }
            return phuTroi;
        }

        public int getTongTien() {
            return this.getPhuTroi() + this.getThanhTien();
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

        @Override
        public String toString() {
            return String.format("%s %d %d %d %d", this.ma, this.getHeSo(), this.getThanhTien(), this.getPhuTroi(),
                    this.getTongTien());
        }
    }

    protected static class DanhSachKhachHang {
        private ArrayList<KhachHang> ds;

        DanhSachKhachHang() {
            this.ds = new ArrayList<>();
        }

        protected void them(KhachHang kh) {
            kh.setMa(this.ds.size() + 1);
            this.ds.add(kh);
        }

        protected void sapXep() {
            Collections.sort(this.ds, new Comparator<KhachHang>(){
                public int compare(KhachHang a, KhachHang b) {
                    return b.getTongTien() - a.getTongTien();
                }
            });
        }

        protected void hienThi() {
            for (KhachHang kh : this.ds) {
                System.out.println(kh);
            }
        }
    }
}
