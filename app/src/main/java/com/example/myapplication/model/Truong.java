package com.example.myapplication.model;

import java.util.List;
public class Truong {
    private int id;
    private String ten;
    private String moTa;
    private int hinhAnh;
    private String hocPhi;
    private float danhGia;
    private List<String> anhList;     // List URL hoặc drawable name
    private List<String> thongTinChung;
    public Truong(String ten, String moTa, int hinhAnh) {
        this.ten = ten;
        this.moTa = moTa;
        this.hinhAnh = hinhAnh;
    }
    public Truong(int id, String ten, String moTa, String hocPhi, float danhGia,
                  List<String> anhList, List<String> thongTinChung) {
        this.id = id;
        this.ten = ten;
        this.moTa = moTa;
        this.hocPhi = hocPhi;
        this.danhGia = danhGia;
        this.anhList = anhList;
        this.thongTinChung = thongTinChung;
    }

    public <T> Truong(int i, String đhBáchKhoa, String trườngTopĐầuVềCntt, int icLauncherBackground, String s, float v, List<T> list, List<T> list1) {
    }

    public int getId(){return id;}
    public String getTen() { return ten; }
    public String getMoTa() { return moTa; }
    public int getHinhAnh() { return hinhAnh; }
    public String getHocPhi() { return hocPhi; }
    public float getDanhGia() { return danhGia; }
    public List<String> getAnhList() { return anhList; }
    public List<String> getThongTinChung() { return thongTinChung; }
}
