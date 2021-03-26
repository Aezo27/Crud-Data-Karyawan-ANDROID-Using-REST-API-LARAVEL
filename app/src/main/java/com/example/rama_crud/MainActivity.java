package com.example.rama_crud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rama_crud.apihelper.BaseApiService;
import com.example.rama_crud.apihelper.Client;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText txtNama;
    private EditText txtNIP;
    private EditText txtAlamat;
    private Button btnTambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kirimData();
            }
        });
    }

    private void kirimData() {
        String nama = txtNama.getText().toString().trim();
        String nip = txtNIP.getText().toString().trim();
        String alamat = txtAlamat.getText().toString().trim();

        BaseApiService apiService = Client.getInstanceRetrofit();
        Call<ResponseBody> call = apiService.addKaryawan(
                nama,
                nip,
                alamat
        );
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initView() {
        txtNama = (EditText) findViewById(R.id.txtNama);
        txtNIP = (EditText) findViewById(R.id.txtNIP);
        txtAlamat = (EditText) findViewById(R.id.txtAlamat);
        btnTambah = (Button) findViewById(R.id.btnSubmit);
    }
}