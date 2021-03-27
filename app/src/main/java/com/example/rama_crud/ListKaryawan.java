package com.example.rama_crud;

import java.util.HashMap;
import java.util.Map;

public class ListKaryawan {

    private String id;
    private String nama;
    private String nip;
    private String alamat;
    private String jenis_kelamin;
    private String divisi;


    public ListKaryawan(String id,String nama, String nip, String alamat, String jenis_kelamin, String divisi) {
        this.id = id;
        this.nama = nama;
        this.nip = nip;
        this.alamat = alamat;
        this.jenis_kelamin = jenis_kelamin;
        this.divisi = divisi;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNip() {
        return nip;
    }
    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }
    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getDivisi() {
        return divisi;
    }
    public void setDivisi(String divisi) {
        this.divisi = divisi;
    }
}
