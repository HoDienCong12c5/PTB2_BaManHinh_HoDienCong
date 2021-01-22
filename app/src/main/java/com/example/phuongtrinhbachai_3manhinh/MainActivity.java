package com.example.phuongtrinhbachai_3manhinh;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText txtPT;
    String Kq;
    public static final int NHAPHS_REQUESTCODE = 111;
    public static final int NHAPHS_RESULTCODE = 112;
    float a,b,c;
    Button btnNhap,btnTinh,btnThoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNhap=(Button)findViewById(R.id.btnNhapSo_main);
        btnTinh=(Button)findViewById(R.id.btnTinh_main);
      //  btnTinh=(Button)findViewById(R.id.btnTinh_main);
        txtPT=(EditText)findViewById(R.id.txtPhuongTrinh_Main);
        btnTinh.setEnabled(false);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnTinh.setEnabled(true);
                Intent intent=new Intent(MainActivity.this, NhapDuLieu.class);
                startActivityForResult(intent,MainActivity.NHAPHS_REQUESTCODE);
            }
        });
        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Kq=giaiPTBac2(a,b,c);
                Intent intent=new Intent(MainActivity.this,KetQua.class);
                Bundle bundle =new Bundle();
                bundle.putString("kq",Kq );
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==MainActivity.NHAPHS_REQUESTCODE && resultCode==MainActivity.NHAPHS_RESULTCODE){
            Bundle bundle = data.getExtras();
            a = bundle.getFloat("a");
            b = bundle.getFloat("b");
            c = bundle.getFloat("c");
            String str = a + "x^2 + " + b + " x + " + c + " = 0";
            txtPT.setText(str);
            btnTinh.setEnabled(true);

        }
    }

    public String giaiPTBac2(float a, float b, float c) {
        // kiểm tra các hệ số
        if (a == 0) {
            if (b == 0) {
                return "Phương trình vô nghiệm!";
            } else {
                return "Phương trình có một nghiệm: "   + "x = " + (-c / b);
            }

        }
        else {
            // tính delta
            float delta = b * b - 4 * a * c;
            float x1;
            float x2;
            // tính nghiệm
            if (delta > 0) {
                x1 = (float) ((-b + Math.sqrt(delta)) / (2 * a));
                x2 = (float) ((-b - Math.sqrt(delta)) / (2 * a));
                return "Phương trình có 2 nghiệm là: "  + "x1 = " + x1 + " và x2 = " + x2;
            } else if (delta == 0) {
                x1 = (-b / (2 * a));
                return "Phương trình có nghiệm kép: "  + "x1 = x2 = " + x1;
            } else {
                return "Phương trình vô nghiệm!";
            }
        }

    }
    public void close(View view) {
        finish();
    }
}