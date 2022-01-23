package javaoop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BangDiemThanhPhan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        DanhSachHocSinh ds = new DanhSachHocSinh();
        while (t-- > 0) {
            HocSinh hs = new HocSinh(in.nextLine(), in.nextLine(), in.nextLine(), in.nextFloat(), in.nextFloat(),
                    in.nextFloat());
            in.nextLine();
            ds.them(hs);
            hs = null;
        }
        ds.sort();
        ds.show();
        in.close();
    }
}

class HocSinh {
    private String msv;
    private String ten;
    private String lop;
    private float diem1;
    private float diem2;
    private float diem3;

    public HocSinh() {
    }

    public HocSinh(String msv, String ten, String lop, float diem1, float diem2, float diem3) {
        this.msv = msv;
        this.ten = ten;
        this.lop = lop;
        this.diem1 = diem1;
        this.diem2 = diem2;
        this.diem3 = diem3;
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

    public float getDiem1() {
        return diem1;
    }

    public void setDiem1(float diem1) {
        this.diem1 = diem1;
    }

    public float getDiem2() {
        return diem2;
    }

    public void setDiem2(float diem2) {
        this.diem2 = diem2;
    }

    public float getDiem3() {
        return diem3;
    }

    public void setDiem3(float diem3) {
        this.diem3 = diem3;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %.1f %.1f %.1f", this.msv, this.ten, this.lop, this.diem1, this.diem2,
                this.diem3);
    }

}

class DanhSachHocSinh {
    private ArrayList<HocSinh> list;

    DanhSachHocSinh() {
        this.list = new ArrayList<>();
    }

    protected void them(HocSinh hs) {
        this.list.add(hs);
    }

    protected void sort() {
        Collections.sort(this.list, new Comparator<HocSinh>() {
            public int compare(HocSinh a, HocSinh b) {
                return a.getMsv().compareTo(b.getMsv());
            }
        });
    }

    protected void show() {
        short i = 0;
        for (HocSinh hs : this.list) {
            System.out.println(++i + " " + hs);
        }
    }
}