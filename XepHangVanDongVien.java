package javaoop;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class XepHangVanDongVien {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int t = in.nextInt();
        in.nextLine();
        DanhSachVanDongVien ds = new DanhSachVanDongVien();
        while (t-- > 0) {
            VanDongVien vdv = new VanDongVien(in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine());
            ds.them(vdv);
        }
        ds.xepHang();
        ds.hienThi();
    }

    protected static class VanDongVien {
        private String ma;
        private String ten;
        private String ngaySinh;
        private int gioXuatPhat;
        private int gioVeDich;
        private int xepHang;

        VanDongVien() {

        }

        public VanDongVien(String ten, String ngaySinh, String gioXuatPhat, String gioVeDich) {
            this.ten = ten;
            this.ngaySinh = ngaySinh;
            this.gioXuatPhat = this.stringToTime(gioXuatPhat);
            this.gioVeDich = this.stringToTime(gioVeDich);
        }

        public String getMa() {
            return ma;
        }

        public void setMa(int stt) {
            this.ma = "VDV" + (stt < 10 ? "0" + stt : String.valueOf(stt));
        }

        public String getTen() {
            return ten;
        }

        public void setTen(String ten) {
            this.ten = ten;
        }

        public String getNgaySinh() {
            return ngaySinh;
        }

        public void setNgaySinh(String ngaySinh) {
            this.ngaySinh = ngaySinh;
        }

        public int getGioXuatPhat() {
            return gioXuatPhat;
        }

        public void setGioXuatPhat(int gioXuatPhat) {
            this.gioXuatPhat = gioXuatPhat;
        }

        public int getGioVeDich() {
            return gioVeDich;
        }

        public void setGioVeDich(int gioVeDich) {
            this.gioVeDich = gioVeDich;
        }

        public int getXepHang() {
            return xepHang;
        }

        public void setXepHang(int xepHang) {
            this.xepHang = xepHang;
        }

        public int stringToTime(String time) {
            String[] temp = time.split(":");
            return Integer.parseInt(temp[0]) * 3600 + Integer.parseInt(temp[1]) * 60 + Integer.parseInt(temp[2]);
        }

        public String timeToString(int time) {
            int hours = time / 3600;
            String _hours = hours < 10 ? "0" + hours : String.valueOf(hours);
            int minutes = (time % 3600) / 60;
            String _minutes = minutes < 10 ? "0" + minutes : String.valueOf(minutes);
            int seconds = ((time % 3600) % 60);
            String _seconds = seconds < 10 ? "0" + seconds : String.valueOf(seconds);
            return String.format("%s:%s:%s", _hours, _minutes, _seconds);
        }

        public int getTuoi() {
            String[] temp = this.ngaySinh.split("/");
            return 2021 - Integer.parseInt(temp[2]);
        }

        public int getUuTien() {
            int tuoi = this.getTuoi();
            if (tuoi < 18) {
                return 0;
            }
            if (tuoi < 25) {
                return 1;
            }
            if (tuoi < 32) {
                return 2;
            }
            return 3;
        }

        public String getThanhTichThucTe() {
            return this.timeToString(this.gioVeDich - this.gioXuatPhat);
        }

        public String getThoiGianUuTien() {
            return this.timeToString(this.getUuTien());
        }

        public String getThanhTichXepHang() {
            return this.timeToString(this.gioVeDich - this.gioXuatPhat - this.getUuTien());
        }

        public int getThoiGianXepHang() {
            return this.stringToTime(this.getThanhTichXepHang());
        }

        @Override
        public String toString() {
            return String.format("%s %s %s %s %s %d", this.ma, this.ten, this.getThanhTichThucTe(),
                    this.getThoiGianUuTien(), this.getThanhTichXepHang(), this.xepHang);
        }
    }

    protected static class DanhSachVanDongVien {
        private final ArrayList<VanDongVien> ds;

        DanhSachVanDongVien() {
            this.ds = new ArrayList<>();
        }

        protected void them(VanDongVien vdv) {
            vdv.setMa(this.ds.size() + 1);
            this.ds.add(vdv);
        }

        protected void sortByMa() {
            Collections.sort(this.ds, new Comparator<VanDongVien>() {
                @Override
                public int compare(VanDongVien o1, VanDongVien o2) {
                    return o1.getMa().compareTo(o2.getMa());
                }
            });
        }

        protected void sortByThanhTich() {
            Collections.sort(this.ds, new Comparator<VanDongVien>() {
                @Override
                public int compare(VanDongVien o1, VanDongVien o2) {
                    return o1.getThoiGianXepHang() - o2.getThoiGianXepHang();
                }
            });
        }

        protected void xepHang() {
            this.sortByThanhTich();
            int counter = 1;
            for (int i = 0; i < this.ds.size(); i++) {
                if (i != 0 && this.ds.get(i).getThoiGianXepHang() != this.ds.get(i - 1).getThoiGianXepHang()) {
                    counter = i + 1;
                }
                this.ds.get(i).setXepHang(counter);
            }
//            this.sortByMa();
        }

        protected void hienThi() {
            for (VanDongVien vdv : this.ds) {
                System.out.println(vdv);
            }
        }
    }
}
