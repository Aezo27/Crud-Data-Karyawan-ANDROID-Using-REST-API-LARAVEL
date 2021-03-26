package com.example.rama_crud.apihelper;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface BaseApiService {
    // Fungsi ini untuk memanggil API http://10.0.2.2:8000/api/tambah-data (localhost)
    @FormUrlEncoded
    @POST("/tambah-data")
    Call<ResponseBody> addKaryawan(@Field("txtNama") String nama,
                                   @Field("txtNIP") String nip,
                                   @Field("txtAlamat") String alamat
    );
}
