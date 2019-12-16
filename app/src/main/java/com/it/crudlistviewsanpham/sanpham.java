package com.it.crudlistviewsanpham;

public class sanpham {
    private String Masp;
    private String Tensp;
    private int Soluong;

    public sanpham(String masp, String tensp, int soluong) {
        Masp = masp;
        Tensp = tensp;
        Soluong = soluong;
    }

    public String getMasp() {
        return Masp;
    }

    public void setMasp(String masp) {
        Masp = masp;
    }

    public String getTensp() {
        return Tensp;
    }

    public void setTensp(String tensp) {
        Tensp = tensp;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int soluong) {
        Soluong = soluong;
    }
}
