package com.example.pc.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnEx, btnIm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEx = findViewById(R.id.btnEx);
        btnIm = findViewById(R.id.btnIm);

        btnEx.setOnClickListener(this);
        btnIm.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEx:
                Intent intent = new Intent(this, ExplicitActivity.class);
                startActivity(intent);
                break;
            case R.id.btnIm:
                Intent i = new Intent(this, ImplicitActivity.class);
                startActivity(i);
                break;
        }
    }
}
