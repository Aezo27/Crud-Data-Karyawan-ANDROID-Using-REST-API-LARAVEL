package com.example.rama_crud;

import java.util.HashMap;
import java.util.Map;

//Listbuku.java

public class ListKaryawan {
    //Variabel dalam json
    private int id;
    private String nama;
    private String nip;
    private String alamat;
    private String jenis_kelamin;
    private String divisi;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     *     The id
     */
    //getter dan setter
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     *     The id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     *     The nama
     */
    /**
     *
     * @return
     *     The nama
     */
    //getter dan setter
    public String getNama() {
        return nama;
    }

    /**
     *
     * @param nama
     *     The nama
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     *
     * @return
     *     The nama
     */
    public String getNip() {
        return nip;
    }

    /**
     *
     * @param nip
     *     The nip
     */
    public void setNip(String nip) {
        this.nip = nip;
    }

    /**
     *
     * @return
     *     The nip
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     *
     * @param alamat
     *     The alamat
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    /**
     *
     * @return
     *     The alamat
     */
    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    /**
     *
     * @param jenis_kelamin
     *     The jenis_kelamin
     */
    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }
    public String getDivisi() {
        return divisi;
    }

    /**
     *
     * @param divisi
     *     The divisi
     */
    public void setDivisi(String divisi) {
        this.divisi = divisi;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
