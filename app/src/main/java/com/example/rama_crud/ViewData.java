package com.example.rama_crud;

import android.app.ProgressDialog;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.rama_crud.apihelper.BaseApiService;
import com.example.rama_crud.apihelper.Client;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewData extends AppCompatActivity implements ListView.OnItemClickListener {

    //deklarasi varibel untuk mengirim data ke activity lain
    public static final String id = "id";
    public static final String nama = "nama";
    public static final String nip = "nip";
    public static final String alamat = "alamat";
    public static final String jenis_kelamin = "jenis_kelamin";
    public static final String divisi = "divisi";
    //listview untuk menampilkan data
    private ListView listView;
    //varibel books bertipe List dan List tersebut berdasarkan objek Listbuku
//    private List<ListKaryawan> karyawan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);
        //inisialisasi listview
        listView = (ListView) findViewById(R.id.listView);

        //memanggil method untuk mengambil data buku
        getBuku();

        //setting onItemClickListener untuk listview
//        listview.setOnItemClickListener(this);


    }

    private void getBuku() {
        //Ketika Aplikasi mengambil data kita akan melihat progress dialog
        final ProgressDialog loading = ProgressDialog.show(this,"Fetching Data","Please Wait..",false,false);

        BaseApiService apiService = Client.getInstanceRetrofit();

        Call<List<ListKaryawan>> call = apiService.getKaryawan();
        call.enqueue(new Callback<List<ListKaryawan>>() {
            @Override
            public void onResponse(Call<List<ListKaryawan>> call, Response<List<ListKaryawan>> response) {
                loading.dismiss();
                List<ListKaryawan> karyawan = response.body();
//                    showList();
                //String array untuk menyimpan nama semua nama buku
                String[] items = new String[karyawan.size()];

                for (int i = 0; i < karyawan.size(); i++) {
                    items[i] = karyawan.get(i).getNama();
                }
                //Membuat Array Adapter for listview
                ArrayAdapter adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, items);

                //setting adapter untuk listview
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<ListKaryawan>> call, Throwable t) {
                Toast.makeText(ViewData.this, "Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //method ini akan dieksekusi ketikan listitem diklik
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //membuat intent
//        Intent intent = new Intent(this, LihatDetailBuku.class);
//        //mengambil buku dari list
//        Listbuku listbuku = books.get(position);
//        //menambahkan detail buku untuk intent
//        intent.putExtra(ID_BUKU, listbuku.getIdbuku());
//        intent.putExtra(NAMA_BUKU, listbuku.getNama());
//        intent.putExtra(HARGA_BUKU, listbuku.getHarga());
//        intent.putExtra(STATUS_BUKU, listbuku.getStatus());
//
//        //memulai activity lain untuk menampilkan detail buku
//        startActivity(intent);

    }
}