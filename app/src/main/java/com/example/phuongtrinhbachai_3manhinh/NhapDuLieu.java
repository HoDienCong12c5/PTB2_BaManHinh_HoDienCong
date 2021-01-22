package com.example.phuongtrinhbachai_3manhinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NhapDuLieu extends AppCompatActivity {
    EditText SoA,SoB,SoC;
    float a,b,c ;
    Button btnXong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhap_du_lieu);
        SoA=(EditText)findViewById(R.id.txtSoA_NhapSo);
        SoB=(EditText)findViewById(R.id.txtSoB_NhapSo);
        SoC=(EditText)findViewById(R.id.txtSoC_NhapSo);
        btnXong=(Button)findViewById(R.id.btnXong);
        btnXong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                a=Float.parseFloat(SoA.getText().toString());
                b=Float.parseFloat(SoB.getText().toString());
                c=Float.parseFloat(SoC.getText().toString());
                Intent intent = getIntent();
                Bundle bundle = new Bundle();
                bundle.putFloat("a", a);
                bundle.putFloat("b", b);
                bundle.putFloat("c", c);
                intent.putExtras(bundle);
                setResult(MainActivity.NHAPHS_RESULTCODE,intent);
                finish();
            }
        });
    }
}