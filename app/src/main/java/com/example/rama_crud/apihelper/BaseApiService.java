package com.example.rama_crud.apihelper;

import com.example.rama_crud.ListKaryawan;

import java.util.List;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface BaseApiService {
    // Fungsi ini untuk memanggil API http://10.0.2.2:8000/api/tambah-data (localhost)
    @FormUrlEncoded
    @POST("tambah-data")
    Call<ResponseBody> addKaryawan(@Field("nama") String nama,
                                   @Field("nip") String nip,
                                   @Field("alamat") String alamat
    );
    @GET("data")
    Call<List<ListKaryawan>> getKaryawan();
//    @FormUrlEncoded
    @DELETE("hapus-data/{id}")
    Call<ResponseBody> deleteKaryawan(@Path("id") String id);
    @FormUrlEncoded
    @PUT("update-data")
    Call<ResponseBody> updateKaryawan(@Field("id") String id,
                                      @Field("nama") String nama,
                                      @Field("nip") String nip,
                                      @Field("alamat") String alamat
    );}
