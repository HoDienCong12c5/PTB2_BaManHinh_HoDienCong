package com.example.phuongtrinhbachai_3manhinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class KetQua extends AppCompatActivity {
    Button btnThoat;
    EditText txtKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ket_qua);
        btnThoat=(Button)findViewById(R.id.btnTroVe_KetQua);
        txtKetQua=(EditText)findViewById(R.id.txtKetQua_ketQua);
        Intent intent = getIntent();
        Bundle bundle= intent.getExtras();
        String kq =bundle.getString("kq");
        txtKetQua.setText(kq);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               setResult(MainActivity.NHAPHS_RESULTCODE,intent);
               finish();
            }
        });
    }
}