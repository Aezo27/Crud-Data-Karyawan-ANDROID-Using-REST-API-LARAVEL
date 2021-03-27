package com.example.rama_crud;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rama_crud.apihelper.BaseApiService;
import com.example.rama_crud.apihelper.Client;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewKaryawan extends AppCompatActivity {


    private EditText txtNama;
    private EditText txtNIP;
    private EditText txtAlamat;
    private Button btnEdit;
    private Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_karyawan);

        initView();

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kirimData();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlert();
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
                    Toast.makeText(ViewKaryawan.this, "Berhasil", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(ViewKaryawan.this, "Gagal", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initView() {
        txtNama = (EditText) findViewById(R.id.txtNama);
        txtNIP = (EditText) findViewById(R.id.txtNIP);
        txtAlamat = (EditText) findViewById(R.id.txtAlamat);
        btnEdit = (Button) findViewById(R.id.btnSubmit);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        Intent intent = getIntent();
        //Menampilkan nilai hasil parsing dari intent
//        txtNama.setText("ID : "+String.valueOf(intent.getIntExtra(MainActivity.ID_BUKU,0)));
        txtNama.setText(intent.getStringExtra(ViewData.nama));
        txtAlamat.setText(intent.getStringExtra(ViewData.alamat));
        txtNIP.setText(intent.getStringExtra(ViewData.nip));
    }

    public void showAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Apakah anda yakin?");
        builder.setMessage("Data yang dihapus tidak dapat dikembalikan!");
        builder.setPositiveButton("Confirm",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}