package com.example.pc.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Float fthamsothunhat, fthamsothuhai;
    String stoantu, sxuatmanhinh ="";
    EditText etGiatri;
    Button btnAc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etGiatri = findViewById(R.id.etKetqua);
        btnAc = findViewById(R.id.btnAC);

        int[] idButton = {R.id.btnAC,R.id.btnCongtru,R.id.btnPercent,R.id.btnCong,R.id.btnTru,R.id.btnNhan,R.id.btnChia,
                R.id.btnBang, R.id.btnCham,R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,
                R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9};

        for (int id:idButton){
            View v = (View)findViewById(id);
            v.setOnClickListener(this);
        }

    }

    public void AC(){
        btnAc.setText("AC");
    }

    private void Toantu(){
        fthamsothunhat = Float.parseFloat(etGiatri.getText().toString());
        sxuatmanhinh = "0";
        etGiatri.setText("0");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAC:
                AC();
            case R.id.btnCong:
                stoantu = "+";
                Toantu();
                break;
            case R.id.btnTru:
                stoantu = "-";
                Toantu();
                break;
            case R.id.btnNhan:
                stoantu = "*";
                Toantu();
                break;
            case R.id.btnChia:
                stoantu = "/";
                Toantu();
                break;
            case R.id.btnPercent:
                stoantu = "%";
                Toantu();
                break;
            case R.id.btnBang:
                Float ketqua = null;
                fthamsothuhai = Float.parseFloat(etGiatri.getText().toString());
                if (stoantu == "+"){
                    ketqua = fthamsothunhat + fthamsothuhai;
                }
                if (stoantu == "-"){
                    ketqua = fthamsothunhat - fthamsothuhai;
                }
                if (stoantu == "*"){
                    ketqua = fthamsothunhat * fthamsothuhai;
                }
                if (stoantu == "/"){
                    ketqua = fthamsothunhat / fthamsothuhai;
                }
                if (stoantu == "%"){
                    ketqua = fthamsothunhat / 100;
                }
                etGiatri.setText(String.valueOf(ketqua));
                fthamsothunhat = 0.0f;
                fthamsothuhai = 0.0f;

                sxuatmanhinh = "0";

                break;

            default:
                if (sxuatmanhinh.equals("0")){
                    sxuatmanhinh = "";
                }

            sxuatmanhinh += ((Button)v).getText().toString();
            etGiatri.setText(sxuatmanhinh);
        }
    }
}
