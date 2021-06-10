package com.jp.practicawd;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import id.ionbit.ionalert.IonAlert;

public class InicialApi extends AppCompatActivity implements View.OnClickListener {
    ImageView ivWhisky;
    ImageView ivDistillery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial_api);
        ivWhisky=findViewById(R.id.ivWhisky);
        ivDistillery=findViewById(R.id.ivDistillery);
        ivWhisky.setOnClickListener(this);
        ivDistillery.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ivWhisky) {


            Intent intent= new Intent(this,MainActivity.class);
            startActivity(intent);

        }
        if (v.getId() == R.id.ivDistillery) {
            Intent intent= new Intent(this,Distilleries.class);
            startActivity(intent);
        }
    }
}